package com.crumbs.lib.repository;

import com.crumbs.lib.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
