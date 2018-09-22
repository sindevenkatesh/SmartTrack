package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KeyWords {

	// MSP login
/*	@FindBy(id = "DefaultContent_TxtEmailAddress")
	public WebElement UserName;	
	
	@FindBy(id = "DefaultContent_TxtPassword")
	public WebElement Password;
	@FindBy(id = "DefaultContent_btnLog")
	public WebElement LoginBtn;*/
	
	public static By UserName = By.id("DefaultContent_TxtEmailAddress");
	public static By Password = By.id("DefaultContent_TxtPassword");
	public static By LoginBtn = By.id("DefaultContent_btnLog");
	
	
	
	
	
	
	
	// Client Selection
	@FindBy(xpath = "/html/body/div[1]/nav/div[1]/ul/li[1]/a/img")
	public WebElement Clientlink;
	@FindBy(xpath = "//*[@id=\'clientMenu\']/li[1]/input")
	public WebElement Clientselect;
	@FindBy(xpath = "//*[@class='list-group-item'][@data-clientname='supervalu']")
	public WebElement Client;

	// Home--Requisition--Create Requisition

	// a[@class='gn-icon-menu'][@data-toggle='popover']
	@FindBy(xpath = "//a[@class='gn-opener gn-icon gn-icon-menu'][@data-toggle='popover']")
	public WebElement HomeBtn;
	@FindBy(xpath = "//a[@class='gn-icon gn-parent-menu'][text()='Home']")
	public WebElement HomeOpen;

	@FindBy(xpath = "//a[@class='gn-icon gn-parent-menu'][text()='Requisitions']")
	public WebElement Requisitions;

	@FindBy(xpath = "//*[@class='gn-submenu']//li[contains(normalize-space(),'Create Requisitions')]")
	public WebElement CreateRequisitions;

	// New req
	@FindBy(xpath = "//*[@id='etkresult']//b[contains(normalize-space(),'New Requisition')]")
	public WebElement NewRequisitionsLink1;
	@FindBy(xpath = "//*[@class='ui-corner-all tip wcagtrigger']//b[contains(normalize-space(),'New Requisition')]")
	public WebElement NewRequisitionsLink2;

	// Outline Tab
	@FindBy(id = "serviceMethodID")
	public WebElement ID_Outline_Select_LaborCategory_serviceMethodID;

	@FindBy(id = "hiringManager")
	public WebElement ID_Outline_Typeahead_EngagingManager_hiringManager;

	// Outline Tab
	@FindBy(xpath = "//*[@class='col-md-12 mbottom15 mtop15']")
	public WebElement Fieldsmarkedwitharemandatory;

	@FindBy(id = "CostCenterId")
	public WebElement ID_Select_CostCenter_CostCenterId;

	@FindBy(id = "GLId")
	public WebElement ID_Select_GeneralLedgerAccount_GLId;

	@FindBy(id = "organizationID")
	public WebElement ID_Select_BusinessArea_organizationID;

	@FindBy(id = "association")
	public WebElement ID_Text_LegalEntity_association;

	
	@FindBy(id = "ServDept")
	public WebElement ID_Text_ServiceDept_ServDept;
	@FindBy(id = "ProDept")
	public WebElement ID_Text_ProductDept_ProDept;
	@FindBy(id = "hiringManager")
	public WebElement ID_Typeahead_EngagingManager_hiringManager;
	@FindBy(id = "altHiringManager")
	public WebElement ID_select_AlternateEngagingManager_altHiringManager;
	@FindBy(id = "laborClassCode")
	public WebElement ID_select_UnionName_laborClassCode;
	@FindBy(id = "priority")
	public WebElement ID_select_Priority_priority;
	@FindBy(id = "workScheduleID")
	public WebElement ID_select_WorkWeek_workScheduleID;
	@FindBy(id = "noofresources")
	public WebElement ID_Text_NumberofResources_noofresources;

	@FindBy(id = "reasonToHireID")
	public WebElement ID_select_ReasonforHire_reasonToHireID;

	@FindBy(id = "JustificationtoHire")
	public WebElement ID_Text_JustificationtoHire_JustificationtoHire;

	@FindBy(id = "neededStartDate")
	public WebElement ID_Datepicker_AssignmentStartDate_neededStartDate;

	@FindBy(id = "enddate")
	public WebElement ID_Datepicker_AssignmentEndDate_enddate;

	@FindBy(id = "workLocationID")
	public WebElement ID_select_WorkLocation_workLocationID;

	@FindBy(id = "siteLocationID")
	public WebElement ID_select_Organization_siteLocationID;

	@FindBy(id = "workLocationAddress")
	public WebElement ID_Typeahead_WorkLocationAddress_workLocationAddress;

}
