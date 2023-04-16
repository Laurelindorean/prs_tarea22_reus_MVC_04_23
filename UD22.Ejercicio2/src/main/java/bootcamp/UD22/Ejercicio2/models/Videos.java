/**
 * 
 */
package bootcamp.UD22.Ejercicio2.models;

/**
 * @author Palmira
 *
 */
public class Videos {
	
	private int id;
	private String title;
	private String director;
	private int cli_id;
	
	//SETTERS Y GETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getCli_id() {
		return cli_id;
	}
	public void setCli_id(int cli_id) {
		this.cli_id = cli_id;
	}
	@Override
	public String toString() {
		return "Videos [id=" + id + ", title=" + title + ", director=" + director + ", cli_id=" + cli_id + "]";
	}
	

}
