package np.com.mshrestha.bookstore.dao.impl;

import java.util.List;

import np.com.mshrestha.bookstore.dao.BookDao;
import np.com.mshrestha.bookstore.model.Book;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveBook(Book book) {
		getSession().merge(book);

	}

	@SuppressWarnings("unchecked")
	public List<Book> listBooks() {

		return getSession().createCriteria(Book.class).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Book> listBooksForCode(int code) {
		
		Criteria cr = getSession().createCriteria(Book.class);
		cr.add(Restrictions.eq("code", code+""));
		cr.add(Restrictions.like("name", "pravesh"));
		List results = cr.list();

		return results;
	}

	public Book getBook(Long id) {
		return (Book) getSession().get(Book.class, id);
	}

	public void deleteBook(Long id) {

		Book book = getBook(id);

		if (null != book) {
			getSession().delete(book);
		}

	}

	private Session getSession() {
		Session sess = getSessionFactory().getCurrentSession();
		if (sess == null) {
			sess = getSessionFactory().openSession();
		}
		return sess;
	}

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
