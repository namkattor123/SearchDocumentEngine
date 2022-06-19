package SearchDocument.SearchDocument.Service.Impl;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SearchDocument.SearchDocument.Service.GeneralInfoKeyWordService;
import SearchDocument.SearchDocument.model.DocumentDTO;
import SearchDocument.SearchDocument.repository.CustomQuery;
import SearchDocument.SearchDocument.repository.GeneralInfoKeyWordRepository;

@Service
public class GeneralInfoKeyWordServiceImpl implements  GeneralInfoKeyWordService{
	
@Autowired
private GeneralInfoKeyWordRepository generalInfoKeyWordRepository;
@Autowired
private CustomQuery customQuery;
	

	
	public void readDocxFile(String fileName) {

		try {
			File file = new File(fileName);
			FileInputStream fis = new FileInputStream(file.getAbsolutePath());

			XWPFDocument document = new XWPFDocument(fis);

			List<XWPFParagraph> paragraphs = document.getParagraphs();
			
			System.out.println("Total no of paragraph "+paragraphs.size());
			for (XWPFParagraph para : paragraphs) {
				System.out.println(para.getText());
			}
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<DocumentDTO> findKey(List<String> res) {
		
		return customQuery.selectDocument(res);
	}

}
