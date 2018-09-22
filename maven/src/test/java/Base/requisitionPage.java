package Base;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class requisitionPage {
	static Logger Log = Logger.getLogger(requisitionPage.class.getName());
	public WebDriver driver;

	public requisitionPage(WebDriver driver) {
		this.driver = driver;
	}

	// OutlineTab

	public void Supervalu(Row r1) {
		
		KeyWords kw = PageFactory.initElements(driver, KeyWords.class);
		
		// Cost Center *
		if (kw.ID_Select_CostCenter_CostCenterId != null) {			
			// Operation
			String CostCenterData = r1.getCell(10).getStringCellValue();
			Select CostCenterDD = new Select(kw.ID_Select_CostCenter_CostCenterId);
			CostCenterDD.selectByVisibleText(CostCenterData);
			if (CostCenterData == null) {
				CostCenterDD.selectByIndex(5);
			}

		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		/*
		 * // Store/Unit Name // String StoreUnitName =
		 * r.getCell(11).getStringCellValue(); // General Ledger Account * if
		 * (kw.ID_Select_GeneralLedgerAccount_GLId != null) { Select
		 * GeneralLedgerAccountDD = new Select(kw.ID_Select_GeneralLedgerAccount_GLId);
		 * String GeneralLedgerAccount = r1.getCell(12).getStringCellValue(); if
		 * (GeneralLedgerAccount == null) { GeneralLedgerAccountDD.selectByIndex(1); } }
		 * // Business Area * if (kw.ID_Select_BusinessArea_organizationID != null) {
		 * Select BusinessAreaDD = new Select(kw.ID_Select_BusinessArea_organizationID);
		 * String BusinessArea = r1.getCell(13).getStringCellValue();
		 * BusinessAreaDD.selectByVisibleText(BusinessArea); if (BusinessArea == null) {
		 * BusinessAreaDD.selectByIndex(1); } }
		 * 
		 * // Legal Entity * if (kw.ID_Text_LegalEntity_association != null) {
		 * 
		 * String LegalEntityText = r1.getCell(14).getStringCellValue();
		 * kw.ID_Text_LegalEntity_association.sendKeys(LegalEntityText); if
		 * (LegalEntityText == null) {
		 * kw.ID_Text_LegalEntity_association.sendKeys(LegalEntityText); } }
		 * 
		 * // Service Dept if (kw.ID_Text_ServiceDept_ServDept != null) {
		 * 
		 * String ServiceDept = r1.getCell(15).getStringCellValue();
		 * kw.ID_Text_ServiceDept_ServDept.sendKeys(ServiceDept); if (ServiceDept ==
		 * null) { kw.ID_Text_ServiceDept_ServDept.sendKeys(ServiceDept); } } // Product
		 * Dept if (kw.ID_Text_ProductDept_ProDept != null) {
		 * 
		 * String ProductDept = r1.getCell(16).getStringCellValue();
		 * kw.ID_Text_ProductDept_ProDept.sendKeys(ProductDept); if (ProductDept ==
		 * null) { kw.ID_Text_ProductDept_ProDept.sendKeys(ProductDept); } } // Engaging
		 * Manager * // String EngagingManager = r.getCell(17).getStringCellValue(); //
		 * ID_Typeahead_EngagingManager_hiringManager
		 * 
		 * // Alternate Engaging Manager *
		 * 
		 * if (kw.ID_select_AlternateEngagingManager_altHiringManager != null) { Select
		 * AlternateEngagingManagerDD = new
		 * Select(kw.ID_select_AlternateEngagingManager_altHiringManager); String
		 * AlternateEngagingManager = r1.getCell(18).getStringCellValue();
		 * AlternateEngagingManagerDD.selectByVisibleText(AlternateEngagingManager); if
		 * (AlternateEngagingManager == null) {
		 * AlternateEngagingManagerDD.selectByIndex(1); } } // Union Name if
		 * (kw.ID_select_UnionName_laborClassCode != null) { Select UnionNameDD = new
		 * Select(kw.ID_select_UnionName_laborClassCode); String UnionName =
		 * r1.getCell(19).getStringCellValue();
		 * UnionNameDD.selectByVisibleText(UnionName); if (UnionName == null) {
		 * UnionNameDD.selectByIndex(1); } } // Priority * if
		 * (kw.ID_select_Priority_priority != null) { Select PriorityDD = new
		 * Select(kw.ID_select_Priority_priority); String Priority =
		 * r1.getCell(20).getStringCellValue();
		 * PriorityDD.selectByVisibleText(Priority); if (Priority == null) {
		 * PriorityDD.selectByIndex(1); } } // Work Week * if
		 * (kw.ID_select_WorkWeek_workScheduleID != null) { Select WorkWeekDD = new
		 * Select(kw.ID_select_WorkWeek_workScheduleID); String WorkWeek =
		 * r1.getCell(21).getStringCellValue();
		 * WorkWeekDD.selectByVisibleText(WorkWeek); if (WorkWeek == null) {
		 * WorkWeekDD.selectByIndex(1); } } // Number of Resources * if
		 * (kw.ID_Text_NumberofResources_noofresources != null) {
		 * 
		 * String NumberofResourcesText = r1.getCell(22).getStringCellValue();
		 * kw.ID_Text_NumberofResources_noofresources.sendKeys(NumberofResourcesText);
		 * if (NumberofResourcesText == null) {
		 * kw.ID_Text_NumberofResources_noofresources.sendKeys(NumberofResourcesText); }
		 * } // Reason for Hire if (kw.ID_select_ReasonforHire_reasonToHireID != null) {
		 * Select ReasonforHireDD = new
		 * Select(kw.ID_select_ReasonforHire_reasonToHireID); String ReasonforHire =
		 * r1.getCell(23).getStringCellValue();
		 * ReasonforHireDD.selectByVisibleText(ReasonforHire); if (ReasonforHire ==
		 * null) { ReasonforHireDD.selectByIndex(1); } } // Justification to Hire if
		 * (kw.ID_Text_JustificationtoHire_JustificationtoHire != null) {
		 * 
		 * String JustificationtoHireText = r1.getCell(24).getStringCellValue();
		 * kw.ID_Text_JustificationtoHire_JustificationtoHire.sendKeys(
		 * JustificationtoHireText); if (JustificationtoHireText == null) {
		 * kw.ID_Text_NumberofResources_noofresources.sendKeys(JustificationtoHireText);
		 * } } // Assignment Start Date * // Assignment End Date * //
		 * ID_Datepicker_AssignmentStartDate_neededStartDate //
		 * ID_Datepicker_AssignmentEndDate_enddate
		 * 
		 * // Work Location * // Organization * // Work Location Address * //
		 * ID_select_WorkLocation_workLocationID //
		 * ID_select_Organization_siteLocationID //
		 * ID_Typeahead_WorkLocationAddress_workLocationAddress
		 * 
		 * // Save & Continue
		 */
	}

}
