package Model.BO;

import java.util.List;

import Model.Bean.Category;
import Model.DAO.CategoryRepository;

public class CategoryService {
	private CategoryRepository categoryRepository = new CategoryRepository();
	public List<Category> getAll(){
		return categoryRepository.getAll();
	}
	
	public int[] getCategoryRevenue() {
		return categoryRepository.getCategoryRevenue();
	}
	
}
