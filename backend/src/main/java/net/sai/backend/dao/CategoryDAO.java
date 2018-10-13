package net.sai.backend.dao;

import java.util.List;

import net.sai.backend.dto.Category;

public interface CategoryDAO {

	List<Category> list();

	Category get(int id);
}
