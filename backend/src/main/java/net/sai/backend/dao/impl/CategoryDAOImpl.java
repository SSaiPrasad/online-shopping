package net.sai.backend.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.sai.backend.dao.CategoryDAO;
import net.sai.backend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<Category>();
	
	static{
		Category category1 = new Category();;
		category1.setId(1);
		category1.setName("Television");
		category1.setDescription("TV Description");
		category1.setImageUrl("CAT_1.jpg");
		
		Category category2 = new Category();;
		category2.setId(2);
		category2.setName("Mobile");
		category2.setDescription("Mobile Description");
		category2.setImageUrl("CAT_2.jpg");
		
		Category category3 = new Category();;
		category3.setId(3);
		category3.setName("Laptops");
		category3.setDescription("Laptop Description");
		category3.setImageUrl("CAT_3.jpg");
		
		Category category4 = new Category();;
		category4.setId(4);
		category4.setName("Refrigerator");
		category4.setDescription("Refrigerator Description");
		category4.setImageUrl("CAT_4.jpg");
		
		categories.add(category1);
		categories.add(category2);
		categories.add(category3);
		categories.add(category4);
		
	}
	
	public List<Category> list() {
		return categories;
	}

	public Category get(int id) {
		// TODO Auto-generated method stub
		for(Category category : categories)
		{
			if(category.getId() == id)
				return category;
		}
		return null;
	}

}
