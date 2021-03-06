package by.easyandroid.webapp.form.appCustomization.section;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import by.easyandroid.database.service.conference.SectionService;
import by.easyandroid.database.service.exception.DatabaseServiceException;
import by.easyandroid.model.conference.Section;
import by.easyandroid.model.util.ModelUtil;
import by.easyandroid.webapp.form.ICrudForm;
import by.easyandroid.webapp.form.appCustomization.AbstractConferenceBaseForm;
import by.easyandroid.webapp.util.Bean;
import by.easyandroid.webapp.util.FacesUtil;

@ManagedBean
@RequestScoped
public class SectionsForm extends AbstractConferenceBaseForm implements ICrudForm<Section> {

	@ManagedProperty(value = "#{createSectionDialog}")
	private SectionDialog createDialog;
	
	@ManagedProperty(value = "#{editSectionDialog}")
	private SectionDialog editDialog;	
	
	@ManagedProperty(value = "#{deleteSectionDialog}")
	private SectionDialog deleteDialog;
	
	@ManagedProperty(value = Bean.SRV_SECTION)
	private SectionService sectionService;
	
	private List<Section> sections = new ArrayList<Section>(); 
	
	@Override
	public void init() throws Exception {
		super.init();
		// TODO load values from database, get request parameter conference id
		// TODO it's better to do that when enabling/disabling opening ConferenceForm
		// TODO check if selected conference belongs to user
		if (template != null) {
			sections = template.getModel().getSections();
		}
	}
	
	@Override
	public void create(ActionEvent event) {
		try {
			if (template != null) {
				sectionService.add(createDialog.getObject(), template);
				createDialog.close();
			}
		} catch (DatabaseServiceException e) {
			// TODO display error message
			e.printStackTrace();
		}
	}
	
	@Override
	public void delete(ActionEvent id) {
		sectionService.delete(deleteDialog.getObject().getId(), template);
		deleteDialog.close();
	}

	@Override
	public void edit(ActionEvent event) {
		sectionService.save(editDialog.getObject());
		
		// Update UI
		ModelUtil.replaceById(sections, editDialog.getObject());
		editDialog.close();
	}	
	
	@Override
	public List<Section> getAll() {
		return sections;
	}
	
	// TODO to interface or base class
	public List<SelectItem> getSelectItems() {
		return FacesUtil.toSelectItems(sections);
	}

	public SectionDialog getEditDialog() {
		return editDialog;
	}

	public void setEditDialog(SectionDialog editDialog) {
		this.editDialog = editDialog;
	}

	public SectionService getSectionService() {
		return sectionService;
	}

	public void setSectionService(SectionService sectionService) {
		this.sectionService = sectionService;
	}

	public SectionDialog getCreateDialog() {
		return createDialog;
	}

	public void setCreateDialog(SectionDialog createDialog) {
		this.createDialog = createDialog;
	}

	public SectionDialog getDeleteDialog() {
		return deleteDialog;
	}

	public void setDeleteDialog(SectionDialog deleteDialog) {
		this.deleteDialog = deleteDialog;
	}
}