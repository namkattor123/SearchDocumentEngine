package SearchDocument.SearchDocument.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import SearchDocument.SearchDocument.model.DocumentDTO;

@Repository
public interface CustomQuery {
	List<DocumentDTO> selectDocument(List<String> inputs);
}
