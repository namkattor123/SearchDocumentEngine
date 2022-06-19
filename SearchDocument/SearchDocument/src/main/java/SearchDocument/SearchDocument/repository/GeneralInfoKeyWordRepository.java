package SearchDocument.SearchDocument.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import SearchDocument.SearchDocument.model.GeneralInfo;
import SearchDocument.SearchDocument.model.GeneralInfoKeyWord;

public interface GeneralInfoKeyWordRepository extends JpaRepository<GeneralInfoKeyWord, Integer> {

@Query(value = "SELECT gi.* FROM searchtext.general_info_keyword as gikw\r\n"
		+ "LEFT JOIN searchtext.keyword as kw\r\n"
		+ "ON gikw.id_key_word = kw.id\r\n"
		+ "LEFT JOIN searchtext.general_info as gi\r\n"
		+ "ON gikw.id_general_info = gi.id\r\n"
		+ "WHERE kw.word = \"substation\"|| kw.word = \"precinct\"\r\n"
		+ "ORDER BY gikw.wij DESC\r\n"
		+ "LIMIT 10;", nativeQuery = true)
List<Object> findDocument(String inputs);
}
