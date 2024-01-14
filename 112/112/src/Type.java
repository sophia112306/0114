import java.util.ArrayList;


import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.List;


public class Type extends Meal{
	
	private String foodType;
	
	public Type(int budget,String location,String foodType) {
		super(budget,location);
		this.foodType=foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType=foodType;
	}
	
	public String getFoodType() {
		return foodType;
	}
	
	
	public List<String> getRecommendedMeal(){
		 List<String> recommendedMeal = new ArrayList<>();
		 
		 
	            
	            
	
	        try {
	            FileInputStream fis = new FileInputStream(new File("餐廳.xlsx"));
	            XSSFWorkbook wb = new XSSFWorkbook(fis);
	            XSSFSheet sheet = wb.getSheetAt(0);
	            Row secondRow=sheet.getRow(1);
	            
	            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
	                Row row = sheet.getRow(i);

	                Cell typeCell = row.getCell(4); 
	                String restaurantType = typeCell.getStringCellValue();

	                if ("輕食".equals(restaurantType)||"台式".equals(restaurantType)||"自助餐".equals(restaurantType)||"蔬食".equals(restaurantType)||"中式".equals(restaurantType) ||"異國".equals(restaurantType)||"韓式".equals(restaurantType)||"速食".equals(restaurantType)){
	                    Cell nameCell = row.getCell(0); 
	                    recommendedMeal.add(nameCell.getStringCellValue());
	                }
	                
	            }

	            fis.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return recommendedMeal;
	    }

	    public void costOfTheMeal() {
	    	super.costOfTheMeal();
	    }
	}
	            
	            
	            

	            