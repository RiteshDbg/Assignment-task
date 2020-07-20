package com.fl.service;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class ReadExcelFileData2 {
	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {

		// String FilePath =
		// "C://Users//ashut//Desktop//IT_Etro_Spa__Renewal_WP239809.xlsb (1).xlsx";
		String FilePath = "./data/SC_GLOBAL_SUPPLY_CENTRE_PTY_LTD_NEW_WP240952.xlsx";
		File file = new File(FilePath);

		Workbook workbook = WorkbookFactory.create(file);
		System.out.println(workbook.getNumberOfSheets());
			Sheet sheet3 = workbook.getSheetAt(1);
		 ReadExcelFileData2 l = new ReadExcelFileData2();
		 List<Object>as=l.posUAEReader(sheet3);
		 System.out.println(as);

	}

	public List<Object> posUAEReader(Sheet sheet) {
		List<Object> valueList = new LinkedList<>();
		try {
		String origin = "Origin_country";
		String destination = "Destination_zone";
		String FC_Flex_Plus_F = "First_Class_FLEX_PLUS_F";
		String FC_Flex_A = "First_Class_FLEX_A";
		String BC_Flex_Plus_JC = "Business_Class_FLEX_JC";
		String BC_Flex_I = "Business_Class_FLEX_I";
		String EC_Flex_Plus_YER = "Economy_Class_FLEX_PLUS_YER";
		String EC_Flex_WMBU = "Economy_Class_FLEX_ WMBU";
		String AC_Flex_K = "All_Cabin_FLEX_K";
		String AC_Saver_OQLTVX = "ALL_Cabin_Saver_OQLTVX";

		String origin_value = "";
		String destination_value = "";
		String FC_Flex_Plus_F_value = "";
		String FC_Flex_A_value = "";
		String BC_Flex_Plus_JC_value = "";
		String BC_Flex_I_value = "";
		String EC_Flex_Plus_YER_value = "";
		String EC_Flex_WMBU_value = "";
		String AC_Flex_K_value = "";
		String AC_Saver_OQLTVX_value = "";

		DBObject map = null;
		Iterator<Row> rowIterator1 = sheet.iterator();
		while (rowIterator1.hasNext()) {
				Row row = rowIterator1.next();
				int n = row.getRowNum();
				if (row.getRowNum() > 4) {
							
//					System.out.println(row.getRowNum());
//					System.out.println(row.getCell(0));
//					System.out.println(row.getCell(1));
//					System.out.println(row.getCell(2));
//					System.out.println(row.getCell(3));
//					System.out.println(row.getCell(4));
//					System.out.println(row.getCell(5));
					if (row.getCell(2) != null && row.getCell(2).getStringCellValue().length() > 0) {
						map = new BasicDBObject();
						
						if (row.getCell(0) != null) {
							if (row.getCell(0).toString() != null && row.getCell(0).toString() != "") {
								if (row.getCell(0).getCellType() == Cell.CELL_TYPE_NUMERIC) {
									if (row.getCell(0) != null) {
										BigDecimal value = new BigDecimal(row.getCell(0).getNumericCellValue());
										System.out.println("");
										origin_value = value.toString();
										
										//
									}
								} else {
									if (row.getCell(0).toString() != null && row.getCell(0).toString() != "") {
										String value = row.getCell(0).getStringCellValue();
										origin_value = value.toString();
										//
									}
								}
								map.put(origin, origin_value);
							} else {
								map.put(origin, origin_value);
							}
						}

						if (row.getCell(1) != null) {
							if (row.getCell(1).toString() != null && row.getCell(1).toString() != "") {
								if (row.getCell(1).getCellType() == Cell.CELL_TYPE_NUMERIC) {
									if (row.getCell(1) != null) {
										BigDecimal value = new BigDecimal(row.getCell(3).getNumericCellValue());
										destination_value = value.toString();
										//
									}
								} else {
									if (row.getCell(1).toString() != null && row.getCell(1).toString() != "") {
										String value = row.getCell(1).getStringCellValue();
										value = value.replaceAll("\n", "");
										destination_value = value.toString();
										//
									}
								}
								map.put(destination, destination_value);
							} else {
								map.put(destination, destination_value);
							}
						}

						if (row.getCell(3) != null) {
							if (row.getCell(3).toString() != null && row.getCell(3).toString() != "") {
								if (row.getCell(3).getCellType() == Cell.CELL_TYPE_NUMERIC) {
									if (row.getCell(3) != null) {
										BigDecimal value = new BigDecimal(row.getCell(3).getNumericCellValue());
										Double dblValue = Double.parseDouble(value.toString());
										dblValue = dblValue * 100;
										FC_Flex_Plus_F_value = Float.parseFloat(dblValue.toString()) + "%";
										//
									}
								} else {
									if (row.getCell(3).toString() != null && row.getCell(3).toString() != "") {
										String value = row.getCell(3).getStringCellValue();
										FC_Flex_Plus_F_value = value.replaceAll("\n", "");
										//
									}
								}
								map.put(FC_Flex_Plus_F, FC_Flex_Plus_F_value);
							} else {
								map.put(FC_Flex_Plus_F, FC_Flex_Plus_F_value);
							}
						}

						if (row.getCell(4) != null) {
							if (row.getCell(4).toString() != null && row.getCell(4).toString() != "") {
								if (row.getCell(4).getCellType() == Cell.CELL_TYPE_NUMERIC) {
									if (row.getCell(4) != null) {
										BigDecimal value = new BigDecimal(row.getCell(4).getNumericCellValue());
										Double dblValue = Double.parseDouble(value.toString());
										dblValue = dblValue * 100;
										FC_Flex_A_value = Float.parseFloat(dblValue.toString()) + "%";
										//
									}
								} else {
									if (row.getCell(4).toString() != null && row.getCell(4).toString() != "") {
										String value = row.getCell(4).getStringCellValue();
										FC_Flex_A_value = value.replaceAll("\n", "");
										//
									}
								}
								map.put(FC_Flex_A, FC_Flex_A_value);
							} else {
								map.put(FC_Flex_A, FC_Flex_A_value);
							}
						}

						
						if (row.getCell(5) != null) {
							if (row.getCell(5).toString() != null && row.getCell(5).toString() != "") {
								if (row.getCell(5).getCellType() == Cell.CELL_TYPE_NUMERIC) {
									if (row.getCell(5) != null) {
										BigDecimal value = new BigDecimal(row.getCell(5).getNumericCellValue());
										Double dblValue = Double.parseDouble(value.toString());
										dblValue = dblValue * 100;
										BC_Flex_Plus_JC_value = Float.parseFloat(dblValue.toString()) + "%";
										//
									}
								} else {
									if (row.getCell(5).toString() != null && row.getCell(5).toString() != "") {
										String value = row.getCell(5).getStringCellValue();
										BC_Flex_Plus_JC_value = value.replaceAll("\n", "");
										//
									}
								}
								map.put(BC_Flex_Plus_JC, BC_Flex_Plus_JC_value);
							} else {
								map.put(BC_Flex_Plus_JC, BC_Flex_Plus_JC_value);
							}
						}

						
						if (row.getCell(6) != null) {
							if (row.getCell(6).toString() != null && row.getCell(6).toString() != "") {
								if (row.getCell(6).getCellType() == Cell.CELL_TYPE_NUMERIC) {
									if (row.getCell(6) != null) {
										BigDecimal value = new BigDecimal(row.getCell(6).getNumericCellValue());
										Double dblValue = Double.parseDouble(value.toString());
										dblValue = dblValue * 100;
										BC_Flex_I_value = Float.parseFloat(dblValue.toString()) + "%";
										//
									}
								} else {
									if (row.getCell(6).toString() != null && row.getCell(6).toString() != "") {
										String value = row.getCell(6).getStringCellValue();
										BC_Flex_I_value = value.replaceAll("\n", "");
										//
									}
								}
								map.put(BC_Flex_I, BC_Flex_I_value);
							} else {
								map.put(BC_Flex_I, BC_Flex_I_value);
							}
						}

						
						
						if (row.getCell(7) != null) {
							if (row.getCell(7).toString() != null && row.getCell(7).toString() != "") {
								if (row.getCell(7).getCellType() == Cell.CELL_TYPE_NUMERIC) {
									if (row.getCell(7) != null) {
										BigDecimal value = new BigDecimal(row.getCell(7).getNumericCellValue());
										Double dblValue = Double.parseDouble(value.toString());
										dblValue = dblValue * 100;
										EC_Flex_Plus_YER_value = Float.parseFloat(dblValue.toString()) + "%";
										//
									}
								} else {
									if (row.getCell(7).toString() != null && row.getCell(7).toString() != "") {
										String value = row.getCell(7).getStringCellValue();
										EC_Flex_Plus_YER_value = value.replaceAll("\n", "");
										//
									}
								}
								map.put(EC_Flex_Plus_YER, EC_Flex_Plus_YER_value);
							} else {
								map.put(EC_Flex_Plus_YER, EC_Flex_Plus_YER_value);
							}
						}

						
						if (row.getCell(8) != null) {
							if (row.getCell(8).toString() != null && row.getCell(8).toString() != "") {
								if (row.getCell(8).getCellType() == Cell.CELL_TYPE_NUMERIC) {
									if (row.getCell(8) != null) {
										BigDecimal value = new BigDecimal(row.getCell(8).getNumericCellValue());
										Double dblValue = Double.parseDouble(value.toString());
										dblValue = dblValue * 100;
										EC_Flex_WMBU_value = Float.parseFloat(dblValue.toString()) + "%";
										//
									}
								} else {
									if (row.getCell(8).toString() != null && row.getCell(8).toString() != "") {
										String value = row.getCell(8).getStringCellValue();
										EC_Flex_WMBU_value = value.replaceAll("\n", "");
										//
									}
								}
								map.put(EC_Flex_WMBU, EC_Flex_WMBU_value);
							} else {
								map.put(EC_Flex_WMBU, EC_Flex_WMBU_value);
							}
						}

						
						if (row.getCell(9) != null) {
							if (row.getCell(9).toString() != null && row.getCell(9).toString() != "") {
								if (row.getCell(9).getCellType() == Cell.CELL_TYPE_NUMERIC) {
									if (row.getCell(9) != null) {
										BigDecimal value = new BigDecimal(row.getCell(9).getNumericCellValue());
										Double dblValue = Double.parseDouble(value.toString());
										dblValue = dblValue * 100;
										AC_Flex_K_value = Float.parseFloat(dblValue.toString()) + "%";
										//
									}
								} else {
									if (row.getCell(9).toString() != null && row.getCell(9).toString() != "") {
										String value = row.getCell(9).getStringCellValue();
										AC_Flex_K_value = value.replaceAll("\n", "");
										//
									}
								}
								map.put(AC_Flex_K, AC_Flex_K_value);
							} else {
								map.put(AC_Flex_K, AC_Flex_K_value);
							}
						}

						
						if (row.getCell(10) != null) {
							if (row.getCell(10).toString() != null && row.getCell(10).toString() != "") {
								if (row.getCell(10).getCellType() == Cell.CELL_TYPE_NUMERIC) {
									if (row.getCell(10) != null) {
										BigDecimal value = new BigDecimal(row.getCell(10).getNumericCellValue());
										Double dblValue = Double.parseDouble(value.toString());
										dblValue = dblValue * 100;
										AC_Saver_OQLTVX_value = Float.parseFloat(dblValue.toString()) + "%";
										//
									}
								} else {
									if (row.getCell(10).toString() != null && row.getCell(10).toString() != "") {
										String value = row.getCell(10).getStringCellValue();
										AC_Saver_OQLTVX_value = value.replaceAll("\n", "");
										//
									}
								}
								map.put(AC_Saver_OQLTVX, AC_Saver_OQLTVX_value);
							} else {
								map.put(AC_Saver_OQLTVX, AC_Saver_OQLTVX_value);
							}
						}

						
						

						valueList.add(map);
					} else {
						break;
					}
				}

			}

		} catch(Exception e) {
			e.printStackTrace();
//			logger.error("Exception got : ", e);
		}
		return valueList;

	}
}
//	public List<Object> posUAEReader(Sheet sheet) {
//		List<Object> valueList = new LinkedList<>();
//		try {
//			String origin = "Origin_country";
//			String destination = "Destination_zone";
//			String FC_Flex_Plus_F = "First_Class_FLEX_PLUS_F";
//			String FC_Flex_A = "First_Class_FLEX_A";
//			String BC_Flex_Plus_JC = "Business_Class_FLEX_JC";
//			String BC_Flex_I = "Business_Class_FLEX_I";
//			String EC_Flex_Plus_YER = "Economy_Class_FLEX_PLUS_YER";
//			String EC_Flex_WMBU = "Economy_Class_FLEX_ WMBU";
//			String AC_Flex_K = "All_Cabin_FLEX_K";
//			String AC_Saver_OQLTVX = "ALL_Cabin_Saver_OQLTVX";
//
//			String origin_value = "";
//			String destination_value = "";
//			String FC_Flex_Plus_F_value = "";
//			String FC_Flex_A_value = "";
//			String BC_Flex_Plus_JC_value = "";
//			String BC_Flex_I_value = "";
//			String EC_Flex_Plus_YER_value = "";
//			String EC_Flex_WMBU_value = "";
//			String AC_Flex_K_value = "";
//			String AC_Saver_OQLTVX_value = "";
//
//			DBObject map = null;
//			Iterator<Row> rowIterator1 = sheet.iterator();
//			while (rowIterator1.hasNext()) {
//
//				Row row = rowIterator1.next();
//				int n = row.getRowNum();
//				System.out.println(n);
//				if (row.getRowNum() > 0) {
//					System.out.println(row.getRowNum());
//					System.out.println(row.getCell(0));
//					System.out.println(row.getCell(1));
//					System.out.println(row.getCell(2));
//					System.out.println(row.getCell(3));
//					System.out.println(row.getCell(4));
//					System.out.println(row.getCell(5));
//					if (row.getCell(2) != null) {
//
//						map = new BasicDBObject();
//
//						if (row.getCell(0) != null) {
//							if (row.getCell(0).toString() != null && row.getCell(0).toString() != "") {
//								if (row.getCell(0).getCellType() == Cell.CELL_TYPE_NUMERIC) {
//									if (row.getCell(2) != null) {
//										BigDecimal value = new BigDecimal(row.getCell(2).getNumericCellValue());
//										origin_value = value.toString();
//										
//										//
//									}
//								} else {
//									if (row.getCell(0).toString() != null && row.getCell(2).toString() != "") {
//										String value = row.getCell(2).getStringCellValue();
//										origin_value = value.toString();
//										//
//									}
//								}
//								map.put(origin, origin_value);
//							} else {
//								map.put(origin, origin_value);
//							}
//						}
//
//						if (row.getCell(1) != null) {
//							if (row.getCell(3).toString() != null && row.getCell(3).toString() != "") {
//								if (row.getCell(3).getCellType() == Cell.CELL_TYPE_NUMERIC) {
//									if (row.getCell(3) != null) {
//										BigDecimal value = new BigDecimal(row.getCell(3).getNumericCellValue());
//										destination_value = value.toString();
//										//
//									}
//								} else {
//									if (row.getCell(3).toString() != null && row.getCell(3).toString() != "") {
//										String value = row.getCell(3).getStringCellValue();
//										value = value.replaceAll("\n", "");
//										destination_value = value.toString();
//										//
//									}
//								}
//								map.put(destination, destination_value);
//							} else {
//								map.put(destination, destination_value);
//							}
//						}
//
//						if (row.getCell(3) != null) {
//							if (row.getCell(3).toString() != null && row.getCell(3).toString() != "") {
//								if (row.getCell(3).getCellType() == Cell.CELL_TYPE_NUMERIC) {
//									if (row.getCell(3) != null) {
//										BigDecimal value = new BigDecimal(row.getCell(3).getNumericCellValue());
//										Double dblValue = Double.parseDouble(value.toString());
//										dblValue = dblValue * 100;
//										FC_Flex_F_value = Float.parseFloat(dblValue.toString()) + "%";
//										//
//									}
//								} else {
//									if (row.getCell(3).toString() != null && row.getCell(3).toString() != "") {
//										String value = row.getCell(3).getStringCellValue();
//										FC_Flex_F_value = value.replaceAll("\n", "");
//										//
//									}
//								}
//								map.put(FC_Flex_F, FC_Flex_F_value);
//							} else {
//								map.put(FC_Flex_F, FC_Flex_F_value);
//							}
//						}
//
//						if (row.getCell(6) != null) {
//							if (row.getCell(6).toString() != null && row.getCell(6).toString() != "") {
//								if (row.getCell(6).getCellType() == Cell.CELL_TYPE_NUMERIC) {
//									if (row.getCell(6) != null) {
//										BigDecimal value = new BigDecimal(row.getCell(6).getNumericCellValue());
//										Double dblValue = Double.parseDouble(value.toString());
//										dblValue = dblValue * 100;
//										FC_Flex_A_value = Float.parseFloat(dblValue.toString()) + "%";
//										//
//									}
//								} else {
//									if (row.getCell(6).toString() != null && row.getCell(6).toString() != "") {
//										String value = row.getCell(6).getStringCellValue();
//										FC_Flex_A_value = value.replaceAll("\n", "");
//										//
//									}
//								}
//
//								map.put(FC_Flex_A, FC_Flex_A_value);
//							} else {
//								map.put(FC_Flex_A, FC_Flex_F_value);
//							}
//						}
//						
////						if (row.getCell(7) != null) {
////							if (row.getCell(7).toString() != null && row.getCell(7).toString() != "") {
////								if (row.getCell(7).getCellType() == Cell.CELL_TYPE_NUMERIC) {
////									if (row.getCell(7) != null) {
////										BigDecimal value = new BigDecimal(row.getCell(7).getNumericCellValue());
////										Double dblValue = Double.parseDouble(value.toString());
////										dblValue = dblValue * 100;
////										BC_Flex_JC_value = Float.parseFloat(dblValue.toString()) + "%";
////										//
////									}
////								} else {
////									if (row.getCell(7).toString() != null && row.getCell(7).toString() != "") {
////										String value = row.getCell(7).getStringCellValue();
////										BC_Flex_JC_value = value.replaceAll("\n", "");
////										//
////									}
////								}
////								map.put(BC_Flex_JC, BC_Flex_JC_value);
////							} else {
////								map.put(BC_Flex_JC, BC_Flex_JC_value);
////							}
////						}
//
////						if (row.getCell(8) != null) {
////							if (row.getCell(8).toString() != null && row.getCell(8).toString() != "") {
////								if (row.getCell(8).getCellType() == Cell.CELL_TYPE_NUMERIC) {
////									if (row.getCell(8) != null) {
////										BigDecimal value = new BigDecimal(row.getCell(8).getNumericCellValue());
////										Double dblValue = Double.parseDouble(value.toString());
////										dblValue = dblValue * 100;
////										BC_Flex_I_value = Float.parseFloat(dblValue.toString()) + "%";
////										//
////									}
////								} else {
////									if (row.getCell(8).toString() != null && row.getCell(8).toString() != "") {
////										String value = row.getCell(8).getStringCellValue();
////										BC_Flex_I_value = value.replaceAll("\n", "");
////										//
////									}
////								}
////
////								map.put(BC_Flex_I, BC_Flex_I_value);
////
////							} else {
////								map.put(BC_Flex_I, BC_Flex_JC_value);
////							}
////						}
//
////						if (row.getCell(9) != null) {
////							if (row.getCell(9).toString() != null && row.getCell(9).toString() != "") {
////								if (row.getCell(9).getCellType() == Cell.CELL_TYPE_NUMERIC) {
////									if (row.getCell(9) != null) {
////										BigDecimal value = new BigDecimal(row.getCell(9).getNumericCellValue());
////										Double dblValue = Double.parseDouble(value.toString());
////										dblValue = dblValue * 100;
////										EC_Flex_YER_value = Float.parseFloat(dblValue.toString()) + "%";
////										//
////									}
////								} else {
////									if (row.getCell(9).toString() != null && row.getCell(9).toString() != "") {
////										String value = row.getCell(9).getStringCellValue();
////										EC_Flex_YER_value = value.replaceAll("\n", "");
////										//
////									}
////								}
////								map.put(EC_Flex_YER, EC_Flex_YER_value);
////							} else {
////								map.put(EC_Flex_YER, EC_Flex_YER_value);
////							}
////						}
//
////						if (row.getCell(10) != null) {
////							if (row.getCell(10).toString() != null && row.getCell(10).toString() != "") {
////								if (row.getCell(10).getCellType() == Cell.CELL_TYPE_NUMERIC) {
////									if (row.getCell(10) != null) {
////										BigDecimal value = new BigDecimal(row.getCell(10).getNumericCellValue());
////										Double dblValue = Double.parseDouble(value.toString());
////										dblValue = dblValue * 100;
////										EC_Flex_WMBU_value = Float.parseFloat(dblValue.toString()) + "%";
////										///
////									}
////								} else {
////									if (row.getCell(10).toString() != null && row.getCell(10).toString() != "") {
////										String value = row.getCell(10).getStringCellValue();
////										EC_Flex_WMBU_value = value.replaceAll("\n", "");
////										//
////									}
////								}
////								map.put(EC_Flex_WMBU, EC_Flex_WMBU_value);
////							} else {
////								map.put(EC_Flex_WMBU, EC_Flex_YER_value);
////							}
////						}
//
////						if (row.getCell(11) != null) {
////							if (row.getCell(11).toString() != null && row.getCell(11).toString() != "") {
////								if (row.getCell(11).getCellType() == Cell.CELL_TYPE_NUMERIC) {
////									if (row.getCell(11) != null) {
////										BigDecimal value = new BigDecimal(row.getCell(11).getNumericCellValue());
////										Double dblValue = Double.parseDouble(value.toString());
////										dblValue = dblValue * 100;
////										AC_saver_O_value = Float.parseFloat(dblValue.toString()) + "%";
////										//
////									}
////								} else {
////									if (row.getCell(11).toString() != null && row.getCell(11).toString() != "") {
////										String value = row.getCell(11).getStringCellValue();
////										AC_saver_O_value = value.replaceAll("\n", "");
////										//
////									}
////								}
////								map.put(AC_saver_O, AC_saver_O_value);
////							} else {
////								map.put(AC_saver_O, AC_saver_O_value);
////							}
////						}
//
////						if (row.getCell(12) != null) {
////							if (row.getCell(12).toString() != null && row.getCell(12).toString() != "") {
////								if (row.getCell(12).getCellType() == Cell.CELL_TYPE_NUMERIC) {
////									if (row.getCell(12) != null) {
////										BigDecimal value = new BigDecimal(row.getCell(12).getNumericCellValue());
////										Double dblValue = Double.parseDouble(value.toString());
////										dblValue = dblValue * 100;
////										AC_saver_K_value = Float.parseFloat(dblValue.toString()) + "%";
////										//
////									}
////								} else {
////									if (row.getCell(12).toString() != null && row.getCell(12).toString() != "") {
////										String value = row.getCell(12).getStringCellValue();
////										AC_saver_K_value = value.replaceAll("\n", "");
////										//
////									}
////								}
////								map.put(AC_saver_K, AC_saver_K_value);
////							} else {
////								map.put(AC_saver_K, AC_saver_K_value);
////							}
////						}
//
////						if (row.getCell(13) != null) {
////							if (row.getCell(13).toString() != null && row.getCell(13).toString() != "") {
////								if (row.getCell(13).getCellType() == Cell.CELL_TYPE_NUMERIC) {
////									if (row.getCell(13) != null) {
////										BigDecimal value = new BigDecimal(row.getCell(13).getNumericCellValue());
////										Double dblValue = Double.parseDouble(value.toString());
////										dblValue = dblValue * 100;
////										AC_saver_QLT_value = Float.parseFloat(dblValue.toString()) + "%";
////										//
////									}
////								} else {
////									if (row.getCell(13).toString() != null && row.getCell(13).toString() != "") {
////										String value = row.getCell(13).getStringCellValue();
////										AC_saver_QLT_value = value.replaceAll("\n", "");
////										//
////									}
////								}
////								map.put(AC_saver_QLT, AC_saver_QLT_value);
////							} else {
////								map.put(AC_saver_QLT, AC_saver_QLT_value);
////							}
////						}
//
//						valueList.add(map);
//					} else {
//						break;
//					}
//				}
//
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
////			logger.error("Exception got : ", e);
//		}
//		return valueList;
//	}
//}
