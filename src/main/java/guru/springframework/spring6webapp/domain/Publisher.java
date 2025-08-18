package guru.springframework.spring6webapp.domain;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Publisher {
	
	@Id
	@GeneratedValue
	private Long id;
	private String publisherName;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	
	@OneToMany(mappedBy = "publisher")
	private Set<Book> books;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zipCode;
	}

	public void setZip(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Publisher [id=" + id + ", publisherName=" + publisherName + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", zip=" + zipCode + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, city, id, publisherName, state, zipCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publisher other = (Publisher) obj;
		return Objects.equals(address, other.address) && Objects.equals(city, other.city)
				&& Objects.equals(id, other.id) && Objects.equals(publisherName, other.publisherName)
				&& Objects.equals(state, other.state) && zipCode == other.zipCode;
	}

}
