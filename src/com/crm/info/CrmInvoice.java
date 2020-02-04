package com.crm.info;

import java.sql.Timestamp;

/**
 * CrmInvoice entity. @author MyEclipse Persistence Tools
 */

public class CrmInvoice implements java.io.Serializable {

	// Fields

	private Integer id;
	private CrmCustomer crmCustomer;
	private HrDepartment hrDepartment;
	private ParamSysparam paramSysparam;
	private HrEmployee hrEmployeeByCreateId;
	private CrmOrder crmOrder;
	private HrEmployee hrEmployeeByCEmpid;
	private String invoiceNum;
	private Double invoiceAmount;
	private String invoiceContent;
	private Timestamp invoiceDate;
	private Timestamp createDate;
	private Integer isdelete;
	private Timestamp deleteTime;

	// Constructors

	/** default constructor */
	public CrmInvoice() {
	}

	/** full constructor */
	public CrmInvoice(CrmCustomer crmCustomer, HrDepartment hrDepartment,
			ParamSysparam paramSysparam, HrEmployee hrEmployeeByCreateId,
			CrmOrder crmOrder, HrEmployee hrEmployeeByCEmpid,
			String invoiceNum, Double invoiceAmount, String invoiceContent,
			Timestamp invoiceDate, Timestamp createDate, Integer isdelete, Timestamp deleteTime) {
		this.crmCustomer = crmCustomer;
		this.hrDepartment = hrDepartment;
		this.paramSysparam = paramSysparam;
		this.hrEmployeeByCreateId = hrEmployeeByCreateId;
		this.crmOrder = crmOrder;
		this.hrEmployeeByCEmpid = hrEmployeeByCEmpid;
		this.invoiceNum = invoiceNum;
		this.invoiceAmount = invoiceAmount;
		this.invoiceContent = invoiceContent;
		this.invoiceDate = invoiceDate;
		this.createDate = createDate;
		this.isdelete = isdelete;
		this.deleteTime = deleteTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
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

	public HrDepartment getHrDepartment() {
		return this.hrDepartment;
	}

	public void setHrDepartment(HrDepartment hrDepartment) {
		this.hrDepartment = hrDepartment;
	}

	public ParamSysparam getParamSysparam() {
		return this.paramSysparam;
	}

	public void setParamSysparam(ParamSysparam paramSysparam) {
		this.paramSysparam = paramSysparam;
	}

	public HrEmployee getHrEmployeeByCreateId() {
		return this.hrEmployeeByCreateId;
	}

	public void setHrEmployeeByCreateId(HrEmployee hrEmployeeByCreateId) {
		this.hrEmployeeByCreateId = hrEmployeeByCreateId;
	}

	public CrmOrder getCrmOrder() {
		return this.crmOrder;
	}

	public void setCrmOrder(CrmOrder crmOrder) {
		this.crmOrder = crmOrder;
	}

	public HrEmployee getHrEmployeeByCEmpid() {
		return this.hrEmployeeByCEmpid;
	}

	public void setHrEmployeeByCEmpid(HrEmployee hrEmployeeByCEmpid) {
		this.hrEmployeeByCEmpid = hrEmployeeByCEmpid;
	}

	public String getInvoiceNum() {
		return this.invoiceNum;
	}

	public void setInvoiceNum(String invoiceNum) {
		this.invoiceNum = invoiceNum;
	}

	public Double getInvoiceAmount() {
		return this.invoiceAmount;
	}

	public void setInvoiceAmount(Double invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public String getInvoiceContent() {
		return this.invoiceContent;
	}

	public void setInvoiceContent(String invoiceContent) {
		this.invoiceContent = invoiceContent;
	}

	public Timestamp getInvoiceDate() {
		return this.invoiceDate;
	}

	public void setInvoiceDate(Timestamp invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Integer getIsdelete() {
		return this.isdelete;
	}

	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}

	public Timestamp getDeleteTime() {
		return this.deleteTime;
	}

	public void setDeleteTime(Timestamp deleteTime) {
		this.deleteTime = deleteTime;
	}

}