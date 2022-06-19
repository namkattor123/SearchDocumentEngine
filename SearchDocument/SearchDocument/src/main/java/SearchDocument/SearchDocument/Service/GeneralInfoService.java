package SearchDocument.SearchDocument.Service;

import org.springframework.http.ResponseEntity;

import SearchDocument.SearchDocument.model.GeneralInfoKeyWord;

public interface GeneralInfoService {

	GeneralInfoKeyWord findKey(String input);

}
