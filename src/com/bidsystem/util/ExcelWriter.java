package com.bidsystem.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter<T> {

	/**
	 * 根据数据返回workbook
	 * @param dataList 数据
	 * @param sheetName 表格名称
	 * @param clazz 类型
	 * @return 工作簿
	 */
	public XSSFWorkbook getWorkbook(List<T> dataList , String sheetName , Class clazz) {
		// 创建一个工作簿
		XSSFWorkbook workbook = new XSSFWorkbook();
		// 给工作簿添加一个sheet
		XSSFSheet sheet = workbook.createSheet(sheetName); 
		XSSFRow row0 = sheet.createRow(0);
        
		Field[] fields = clazz.getDeclaredFields(); // 获取该类所有的字段 
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			String fieldName = field.getName();
			XSSFCell cell = row0.createCell(i);
			cell.setCellValue(fieldName);
		}
		try {
			// 写数据行
			// 循环List
			for (int i = 0; i < dataList.size(); i++) {
				T obj = dataList.get(i);
				// 新建一个数据行row对象
				XSSFRow row = sheet.createRow(i + 1);
				// 创建单元格（创建几个单元格，每个单元格是什么？）
				for (int j = 0; j < fields.length; j++) {
					// 属性名
					String propertyName = fields[j].getName();
					// get方法名
					String getMethodName = "get" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
					// 获取get方法
					Method getMethod = clazz.getDeclaredMethod(getMethodName);
					// 调用get方法
					Object value = getMethod.invoke(obj);
					// 创建单元格
					XSSFCell cell = row.createCell(j);
					// 给单元格赋值2
					cell.setCellValue(value == null ? "" : value.toString());
				}
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return workbook;
	}
}
