package appstore.app;

import java.util.Date;

public class App
{

	// Attributes
	private int id;
	private String name;
	private String author;
	private String license;
	private String version;
	private String country;
	private String os;			// Operating system
	private double price;
	private double size; 		// size of download in Mega Bytes
	private int trial;			// Number of trial days
	private Date registerDate;

	
	// Construtor
	public App(String name, String author, double price, String os, String version, double size, String license, String country, int trial)
	{
		this.name = name;
		this.author = author;
		this.price = price;
		this.os = os;
		this.version = version;
		this.size = size;
		this.license = license;
		this.country = country;
		this.trial = trial;
		registerDate = new Date(); // Data atual
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public int getTrial() {
		return trial;
	}

	public void setTrial(int trial) {
		this.trial = trial;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	
	

}