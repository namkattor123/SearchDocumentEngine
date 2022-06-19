package SearchDocument.SearchDocument.controller;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SearchDocument.SearchDocument.Service.GeneralInfoKeyWordService;
import SearchDocument.SearchDocument.Service.GeneralInfoService;
import SearchDocument.SearchDocument.model.DocumentDTO;
import SearchDocument.SearchDocument.model.GeneralInfoKeyWord;
import SearchDocument.SearchDocument.Common;


@Controller
@RequestMapping("/search")
public class SearchDocument {
	
	private final GeneralInfoKeyWordService generalInfoKeywordService;
	
	@Autowired
	public SearchDocument(GeneralInfoKeyWordService generalInfoKeywordService) {
		this.generalInfoKeywordService = generalInfoKeywordService;
	}
    @PostMapping("/result")
    public ResponseEntity<List<DocumentDTO>> Solve(@RequestBody String input){
    	Common commonFunction = new Common();
    	List<String> res = commonFunction.filterInput(input);
    	List<DocumentDTO> result = generalInfoKeywordService.findKey(res);
		return ResponseEntity.ok(result);	
    }
   

    
}
