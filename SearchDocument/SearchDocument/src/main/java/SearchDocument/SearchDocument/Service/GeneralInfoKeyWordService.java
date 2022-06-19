package SearchDocument.SearchDocument.Service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import SearchDocument.SearchDocument.model.DocumentDTO;

@Repository
public interface GeneralInfoKeyWordService {

	List<DocumentDTO> findKey(List<String> res);
	void readDocxFile(String fileName);
}
