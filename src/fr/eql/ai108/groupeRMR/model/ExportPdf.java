package fr.eql.ai108.groupeRMR.model;

import java.util.*;

import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import java.io.FileOutputStream;
import com.pdfjet.*;

import fr.eql.ai108.groupeRMR.ihm.TablePannel;

public class ExportPdf {
	private PDF pdf;
	public ExportPdf(PDF pdf) {
		this.pdf = pdf;
	}

	public static void toFile(TableView<?> tableView, String filename) throws Exception {
		try(FileOutputStream fos = new FileOutputStream(filename)) {
			PDF pdf = new PDF(fos);
			new ExportPdf(pdf).export(tableView);
		}
	}

	public void export(TableView<?> tableView) throws Exception {
		Page page = new Page(pdf, A4.PORTRAIT);
		Font header = new Font(pdf, CoreFont.TIMES_BOLD);
		header.setSize(9.0f);
		Font content = new Font(pdf, CoreFont.TIMES_ROMAN);
		content.setSize(8.0f);
		Table table = new Table();

		List<List<Cell>> tableData = getData(tableView, header, content);
		table.setData(tableData, Table.DATA_HAS_1_HEADER_ROWS);
		table.setCellBordersWidth(0.2f);
		table.setPosition(110.0f, 30.0f);
		table.autoAdjustColumnWidths();
		table.rightAlignNumbers();
		int numOfPages = table.getNumberOfPages(page);
		while (true) {
			float[] point = table.drawOn(page);
			if (!table.hasMoreData()) {
				table.resetRenderedPagesCount();
				break;
			}
			page = new Page(pdf, Letter.PORTRAIT);
		}
		pdf.close();        
	}

	public static List<List<Cell>> getData(TableView<?> tableView, Font header, Font content) {
		List<?> items = tableView.getItems();
		List<List<Cell>> data = new ArrayList<>();
		List<Cell> row = new ArrayList<>();

		for (TableColumn<?, ?> col : tableView.getColumns()) {
			row.add(new Cell(header, col.getText()));
		}
		data.add(row);

		for (int i = 0, n = items.size(); i < n; i++) {
			row = new ArrayList<>();
			for (TableColumn<?, ?> col : tableView.getColumns()) {
				Object value = col.getCellObservableValue(i).getValue();
				String text = value == null ? "" : value.toString();
				row.add(new Cell(content, text));
			}
			data.add(row);
		}
		return data;
	}
	public static void main(String[] args) {
		try {
			
		    ExportPdf.toFile(TablePannel.tableView, "c:/DossierAI108/output.pdf");
		} catch (Exception ex) {
		    // handle Exception
		}
	}
}
