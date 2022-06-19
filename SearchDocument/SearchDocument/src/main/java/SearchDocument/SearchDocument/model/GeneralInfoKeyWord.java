package SearchDocument.SearchDocument.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "general_info_keyword")
public class GeneralInfoKeyWord {
	@Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	
	@Column(name = "idGeneralInfo", nullable = false)
	private Integer idGeneralInfo;
	
	@Column(name = "idKeyWord", nullable = false)
	private Integer idKeyWord;
	
	@Column(name = "Wij", nullable = false)
	private Float Wij;

	public GeneralInfoKeyWord() {
		super();
	}

	public GeneralInfoKeyWord(Integer id, Integer idGeneralInfo, Integer idKeyWord, Float wij) {
		super();
		this.id = id;
		this.idGeneralInfo = idGeneralInfo;
		this.idKeyWord = idKeyWord;
		Wij = wij;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdGeneralInfo() {
		return idGeneralInfo;
	}

	public void setIdGeneralInfo(Integer idGeneralInfo) {
		this.idGeneralInfo = idGeneralInfo;
	}

	public Integer getIdKeyWord() {
		return idKeyWord;
	}

	public void setIdKeyWord(Integer idKeyWord) {
		this.idKeyWord = idKeyWord;
	}

	public Float getWij() {
		return Wij;
	}

	public void setWij(Float wij) {
		Wij = wij;
	}
	
	
}
