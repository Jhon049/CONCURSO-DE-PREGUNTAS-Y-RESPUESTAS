package codigoJhon;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class DataExcel {
	
	public String obtenerPregunta(int hoja, int fila) {
		String stringPreguntasRespuestas = "";
		String rutaProyecto =  System.getProperty("user.dir");
		String nombreArchivo = "\\data.xlsx";
		String rutaArchivo = rutaProyecto + nombreArchivo;
		try (FileInputStream file = new FileInputStream(new File(rutaArchivo))) {
			XSSFWorkbook worbook = new XSSFWorkbook(file);
			XSSFSheet sheet = worbook.getSheetAt(hoja);
			//Iterator<Row> rowIterator = sheet.iterator();
			Row row = sheet.getRow(fila);
			Iterator<Cell> cellIterator = row.cellIterator();
			Cell cell;
			while (cellIterator.hasNext()) {
				cell = cellIterator.next();
				stringPreguntasRespuestas =  stringPreguntasRespuestas + cell.getStringCellValue()+";";
			}
			worbook.close();
		} catch (Exception e) {
			e.getMessage();
		}
		
		return stringPreguntasRespuestas;
	}
}