package codigoJhon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelPuntaje {
	public void guardarPuntaje() {
		Jugador objJugador = new Jugador();
		String name = objJugador.getNombre();
		int puntos = objJugador.getPuntaje();
		String rutaProyecto =  System.getProperty("user.dir");
		String nombreArchivo = "\\data.xlsx";
		String rutaArchivo = rutaProyecto + nombreArchivo;
		try (FileInputStream file = new FileInputStream(new File(rutaArchivo))) {
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet hoja = workbook.getSheetAt(5);
			XSSFRow fila = hoja.createRow(hoja.getLastRowNum()+1);
			XSSFCell nombre = fila.createCell(0);
			XSSFCell puntaje = fila.createCell(1);
			nombre.setCellValue(name);
			puntaje.setCellValue(puntos);
			FileOutputStream out = new FileOutputStream(new File(rutaArchivo));
			workbook.write(out);
		    out.close();  
		    workbook.close();
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
