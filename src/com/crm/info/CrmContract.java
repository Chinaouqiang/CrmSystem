package com.crm.info;

import java.sql.Timestamp;

/**
 * CrmContract entity. @author MyEclipse Persistence Tools
 */

public class CrmContract implements java.io.Serializable {

	// Fields

	private Integer id;
	private CrmCustomer crmCustomer;
	private HrEmployee hrEmployeeByOurContractorId;
	private HrDepartment hrDepartmentByCDepid;
	private HrDepartment hrDepartmentByOurContractorDepid;
	private HrEmployee hrEmployeeByCEmpid;
	private HrEmployee hrEmployeeByCreaterId;
	private String contractName;
	private String serialnumber;
	private Double contractAmount;
	private Integer payCycle;
	private Timestamp startDate;
	private Timestamp endDate;
	private Timestamp signDate;
	private String customerContractor;
	private Timestamp createTime;
	private String mainContent;
	private String remarks;
	private Integer isdelete;
	private Timestamp deleteTime;

	// Constructors

	/** default constructor */
	public CrmContract() {
	}

	/** full constructor */
	

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public CrmContract(Integer id, CrmCustomer crmCustomer, HrEmployee hrEmployeeByOurContractorId,
			HrDepartment hrDepartmentByCDepid, HrDepartment hrDepartmentByOurContractorDepid,
			HrEmployee hrEmployeeByCEmpid, HrEmployee hrEmployeeByCreaterId, String contractName, String serialnumber,
			Double contractAmount, Integer payCycle, Timestamp startDate, Timestamp endDate, Timestamp signDate,
			String customerContractor, Timestamp createTime, String mainContent, String remarks, Integer isdelete,
			Timestamp deleteTime) {
		super();
		this.id = id;
		this.crmCustomer = crmCustomer;
		this.hrEmployeeByOurContractorId = hrEmployeeByOurContractorId;
		this.hrDepartmentByCDepid = hrDepartmentByCDepid;
		this.hrDepartmentByOurContractorDepid = hrDepartmentByOurContractorDepid;
		this.hrEmployeeByCEmpid = hrEmployeeByCEmpid;
		this.hrEmployeeByCreaterId = hrEmployeeByCreaterId;
		this.contractName = contractName;
		this.serialnumber = serialnumber;
		this.contractAmount = contractAmount;
		this.payCycle = payCycle;
		this.startDate = startDate;
		this.endDate = endDate;
		this.signDate = signDate;
		this.customerContractor = customerContractor;
		this.createTime = createTime;
		this.mainContent = mainContent;
		this.remarks = remarks;
		this.isdelete = isdelete;
		this.deleteTime = deleteTime;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CrmCustomer getCrmCustomer() {
		return this.crmCustomer;
	}

	public void setCrmCustomer(CrmCustomer crmCustomer) {
		this.crmCustomer = crmCustomer;
	}

	public HrEmployee getHrEmployeeByOurContractorId() {
		return this.hrEmployeeByOurContractorId;
	}

	public void setHrEmployeeByOurContractorId(
			HrEmployee hrEmployeeByOurContractorId) {
		this.hrEmployeeByOurContractorId = hrEmployeeByOurContractorId;
	}

	public HrDepartment getHrDepartmentByCDepid() {
		return this.hrDepartmentByCDepid;
	}

	public void setHrDepartmentByCDepid(HrDepartment hrDepartmentByCDepid) {
		this.hrDepartmentByCDepid = hrDepartmentByCDepid;
	}

	public HrDepartment getHrDepartmentByOurContractorDepid() {
		return this.hrDepartmentByOurContractorDepid;
	}

	public void setHrDepartmentByOurContractorDepid(
			HrDepartment hrDepartmentByOurContractorDepid) {
		this.hrDepartmentByOurContractorDepid = hrDepartmentByOurContractorDepid;
	}

	public HrEmployee getHrEmployeeByCEmpid() {
		return this.hrEmployeeByCEmpid;
	}

	public void setHrEmployeeByCEmpid(HrEmployee hrEmployeeByCEmpid) {
		this.hrEmployeeByCEmpid = hrEmployeeByCEmpid;
	}

	public HrEmployee getHrEmployeeByCreaterId() {
		return this.hrEmployeeByCreaterId;
	}

	public void setHrEmployeeByCreaterId(HrEmployee hrEmployeeByCreaterId) {
		this.hrEmployeeByCreaterId = hrEmployeeByCreaterId;
	}

	public String getContractName() {
		return this.contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	public String getSerialnumber() {
		return this.serialnumber;
	}

	public void setSerialnumber(String serialnumber) {
		this.serialnumber = serialnumber;
	}

	public Double getContractAmount() {
		return this.contractAmount;
	}

	public void setContractAmount(Double contractAmount) {
		this.contractAmount = contractAmount;
	}

	public Integer getPayCycle() {
		return this.payCycle;
	}

	public void setPayCycle(Integer payCycle) {
		this.payCycle = payCycle;
	}

	

	public String getCustomerContractor() {
		return this.customerContractor;
	}

	public void setCustomerContractor(String customerContractor) {
		this.customerContractor = customerContractor;
	}

	

	public String getMainContent() {
		return this.mainContent;
	}

	public void setMainContent(String mainContent) {
		this.mainContent = mainContent;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getIsdelete() {
		return this.isdelete;
	}

	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public Timestamp getSignDate() {
		return signDate;
	}

	public void setSignDate(Timestamp signDate) {
		this.signDate = signDate;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(Timestamp deleteTime) {
		this.deleteTime = deleteTime;
	}

	

}