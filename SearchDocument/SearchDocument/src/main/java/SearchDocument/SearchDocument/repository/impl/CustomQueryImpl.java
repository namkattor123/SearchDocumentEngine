package SearchDocument.SearchDocument.repository.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import SearchDocument.SearchDocument.model.DocumentDTO;
import SearchDocument.SearchDocument.repository.CustomQuery;
@Repository
public class CustomQueryImpl implements CustomQuery{
	@Autowired
	JdbcTemplate jdbcTemplate;

    private static String BASIC_QUERY = "SELECT gi.title,gi.author,gi.file_name,kw.word,gikw.wij,gikw.id_general_info, sum(wij) as total_wij FROM searchtext.general_info_keyword as gikw\r\n"
    		+ "LEFT JOIN searchtext.keyword as kw\r\n"
    		+ "ON gikw.id_key_word = kw.id\r\n"
    		+ "LEFT JOIN searchtext.general_info as gi\r\n"
    		+ "ON gikw.id_general_info = gi.id\r\n"
    		+ "WHERE kw.word IN (%s)\r\n"
    		+ "GROUP BY gi.file_name\r\n"
    		+ "ORDER BY total_wij DESC\r\n"
    		+ "LIMIT 10;";
    public List<DocumentDTO> selectDocument(List<String> inputs){
        String inSql = String.join(",", Collections.nCopies(inputs.size(), "?"));
        
        @SuppressWarnings("deprecation")
		List<DocumentDTO> result = jdbcTemplate.query(
          String.format(BASIC_QUERY, inSql), 
          inputs.toArray(), 
          (rs, rowNum) -> new DocumentDTO(rs.getString("title"),rs.getString("author"),rs.getString("file_name"),rs.getFloat("total_wij")) );

       return result;
        	    
        
    };

}
