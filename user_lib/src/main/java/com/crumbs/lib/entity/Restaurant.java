package com.crumbs.lib.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "restaurant")

@SqlResultSetMappings({
        @SqlResultSetMapping(name = "SqlResultSetMapping.count", columns = @ColumnResult(name = "cnt"))
})
@NamedNativeQueries(value = {
        @NamedNativeQuery(
                name = "Restaurant.findRestaurantsByLocation",
                query = "select l.id as l_id, ro.id as id, m.id as m_id, m.name as m_name," +
                        "ro.name as name, ro.location_id, m.restaurant_id, owner_id, restaurant_status_id, " +
                        "rating, price_rating, (3959 * acos(cos(radians(:lat)) * cos(radians(latitude)) *" +
                        "cos(radians(longitude) - radians(:lng)) + sin(radians(:lat)) * sin(radians(latitude)))) " +
                        "as distance\n" +
                        "from Restaurant ro\n" +
                        "join Location l on ro.location_id = l.id\n" +
                        "join menu_item m on m.restaurant_id = ro.id\n" +
                        "group by ro.name\n" +
                        "having distance < :maxDistance\n" +
                        "and ((ro.name like concat('%', :query, '%'))\n" +
                        "or m.name like concat('%', :query, '%'))",
                resultClass = Restaurant.class
        ),
        @NamedNativeQuery(
                name = "Restaurant.findRestaurantsByLocation.count",
                query = "select count(distinct restaurant.id)as cnt\n" +
                        "from restaurant\n" +
                        "join location on location_id = location.id\n" +
                        "join menu_item on restaurant_id = restaurant.id\n" +
                        "where (" +
                        "3959 * acos(cos(radians(:lat)) *\n" +
                        "cos(radians(latitude)) *\n" +
                        "cos(radians(longitude) -\n" +
                        "radians(:lng)) +\n" +
                        "sin(radians(:lat)) *\n" +
                        "sin(radians(latitude)))\n" +
                        ") < :maxDistance\n" +
                        "and ((restaurant.name like concat('%', :query, '%')) or (menu_item.name like concat('%', :query, '%')))",
                resultSetMapping = "SqlResultSetMapping.count"
        )
})
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "location_id")
    private Location location;


    private String name;
    private double rating;
    private Integer priceRating;

    @ManyToOne
    @JsonIgnoreProperties("restaurants")
    @JoinColumn(name="owner_id")
    private Owner restaurantOwner;

    @OneToMany(mappedBy="restaurant", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Order> orders;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<MenuItem> menuItems = new ArrayList<>();

    @JsonIgnoreProperties("restaurant")
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<RestaurantCategory> categories = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="restaurant_status_id")
    private RestaurantStatus restaurantStatus;
}

