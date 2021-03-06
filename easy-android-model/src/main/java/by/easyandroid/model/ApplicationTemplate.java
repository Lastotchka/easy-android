package by.easyandroid.model;


/**
 * Android application template. User can create his own android applications from it.
 * 
 * @author kslisenko
 */
public class ApplicationTemplate extends Identity {

	/**
	 * Template title in applications catalog
	 */
	private String title;
	
	/**
	 * Template description in applications catalog
	 */
	private String description;
	
	/**
	 * Url of sample apk (based on this tamplate) for user downloading
	 */
	private String sampleApkUrl;
	
	/**
	 * Url or path to template sources (android project)
	 */
	private String templateSourceUrl;
	
	/**
	 * Url to web application part for editing application model
	 */
	private String webUIPartUrl;
	
	/**
	 * Converter for converting data model to additinal project sources
	 */
	private String converterClassName;
	
//	/**
//	 * Instance with initial data model. Users can not change this instance and allow only copy it themself.
//	 * Instance is a part of template object because or spring data issues (cyclic references bug and no possibility for querying objects by reference objid)
//	 */
//	private ApplicationInstance initialInstance;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSampleApkUrl() {
		return sampleApkUrl;
	}

	public void setSampleApkUrl(String sampleApkUrl) {
		this.sampleApkUrl = sampleApkUrl;
	}

	public String getTemplateSourceUrl() {
		return templateSourceUrl;
	}

	public void setTemplateSourceUrl(String templateSourceUrl) {
		this.templateSourceUrl = templateSourceUrl;
	}

	public String getWebUIPartUrl() {
		return webUIPartUrl;
	}

	public void setWebUIPartUrl(String webUIPartUrl) {
		this.webUIPartUrl = webUIPartUrl;
	}

	public String getConverterClassName() {
		return converterClassName;
	}

	public void setConverterClassName(String converterClassName) {
		this.converterClassName = converterClassName;
	}
//
//	public ApplicationInstance getInitialInstance() {
//		return initialInstance;
//	}
//
//	public void setInitialInstance(ApplicationInstance initialInstance) {
//		this.initialInstance = initialInstance;
//	}
}