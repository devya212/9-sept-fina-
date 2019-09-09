package com.nucleus.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

import com.nucleus.model.Customer;
import com.nucleus.model.Role;
import com.nucleus.model.User;
@Repository
//insert into customer0101(customer_code,customer_name,cust_address1,cust_address2,pin,email,contactno,contact_person,record_status,flag,create_date,created_by) values(?,?,?,?,?,?,?,?,?,?,?,?)
public class CustomerRDBMSDaoImpl implements ICustomerDao  {

	@Autowired
	SessionFactory sessionFactory;
		
		

	@Autowired
	JdbcTemplate jdbctemplate;
	
	/*@Override
	public boolean insert(Customer customer) {
		
		Object obj[]={customer.getCustomerCode(),customer.getCustomerName(),customer.getCustomerAddress1(),customer.getCustomerAddress2(),customer.getCustomerPinCode(),customer.getEmail(),customer.getContactNo(),customer.getPrimaryContactPerson(),customer.getRecordStatus(),customer.getFlag(),new java.sql.Date(customer.getCreateDate().getTime()),customer.getCreatedBy()};
		jdbctemplate.update("insert into customer0101(customer_code,customer_name,cust_address1,cust_address2,pin,email,contactno,contact_person,record_status,flag,create_date,created_by) values(?,?,?,?,?,?,?,?,?,?,?,?)",obj);
	   return true;
	}
*/
	/*@Override
	public boolean delete(Customer customer) {
		Object obj[]={customer.getCustomerCode()};
		jdbctemplate.update("delete from customer0101 where customer_code=?",obj);
	   return true;
	}*/

	/*@Override
	public boolean update(Customer customer, String customerCode) {
		Object obj[]={customer.getCustomerName(),customer.getCustomerAddress1(),customer.getCustomerAddress2()customer.getCustomerPinCode(),customer.getEmail(),customer.getContactNo(),customer.getPrimaryContactPerson(),customer.getRecordStatus(),customer.getFlag()new java.sql.Date(customer.getCreateDate().getTime()),customer.getCreatedBy(),customerCode};
		jdbctemplate.update("update customer0101 set customer_name=?,cust_address1=?,cust_address2=?,pin=?,email=?,contactno=?,contact_person=?,record_status=?,flag=?,create_date=?,created_by=? where customer_code=?",obj);
		   return true;
	}*/

	/*@Override
	public Customer updateCustomer(Customer customer) {
		Customer customer1=jdbctemplate.query("select * from customer0101 where customer_code='"+customer.getCustomerCode()+"'",new ResultSetExtractor<Customer>()
				{

					@Override
					public Customer extractData(ResultSet rs) throws SQLException, DataAccessException {
						if(rs.next())
						{
							Customer customer=new Customer();
							
							customer.setCustomerCode(rs.getString(2));
							customer.setCustomerName(rs.getString(3));
							customer.setCustomerAddress(rs.getString(4));
							//customer.setCustomerAddress2(rs.getString(5));
							customer.setCustomerPinCode(String.valueOf(rs.getInt(6)));
							customer.setEmail(rs.getString(7));
							customer.setContactNo(String.valueOf(rs.getLong(8)));
							//customer.setPrimaryContactPerson(rs.getString(9));
							//customer.setRecordStatus(rs.getString(10));
							//customer.setFlag(rs.getString(11));
							customer.setCreateDate(rs.getDate(12));
							customer.setCreatedBy(rs.getString(13));
							customer.setModifiedDate(rs.getDate(14));
							//customer.setModifiedBy(rs.getString(15));
							//customer.setAuthorizedDate(rs.getDate(16));
							//customer.setAuthorizedBy(rs.getString(17));
							return customer;
						}
						return null;
					}
			
				});
		return customer1;
				}

	
*/	/*public boolean saveUser(User user) {
	
			//sessionFactory.getCurrentSession().persist(customer);
		Session session=sessionFactory.getCurrentSession();
		   Role role1=user.getRole();
		   session.persist(role1);
		   
			
			session.persist(user);
			return true;
			
		
		
	}*/

	@Override
	public boolean insert(Customer customer) {
		Session session=sessionFactory.getCurrentSession();
		   session.persist(customer);
			return true;
		
		
	}

	@Override
	public boolean delete(Customer customer) {
		Session session=sessionFactory.getCurrentSession();
		   session.delete(customer);
			return true;
		
	}

	@Override
	public Customer updateCustomer(String customerCode) {
		Session session=sessionFactory.getCurrentSession();
		   Customer customer=(Customer)session.get(Customer.class,customerCode);
			return customer;
		
	}
	/*@Override
	public Person getPersonById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Person p = (Person) session.load(Person.class, new Integer(id));
		logger.info("Person loaded successfully, Person details="+p);
		return p;
	}

*/

	@Override
	public boolean update(Customer customer, String customerCode) {
		Session session=sessionFactory.getCurrentSession();
		  session.update(customer);
			return true;
	}

	@Override
	public List<Customer> viewAll() {
		
		Session session=sessionFactory.getCurrentSession();
		  List<Customer> list=session.createQuery("from Customer").list();
			return list;
	}

	public boolean checkPrimaryKeyViolationCustomer(String customercode)
	{
		Session session=sessionFactory.getCurrentSession();
		Query query=(Query) session.createQuery("from Customer where customerCode=?");
		query.setParameter(0, customercode);
		List<Customer> list=query.list();
		if(list.isEmpty())
			return false;
		else
		return true;
	}
}