package bookLibrary.service;
import bookLibrary.Dao.QueryDao;
import bookLibrary.Dao.Impl.QueryImpl;
import bookLibrary.bean.Book;

public class query {

    public Book[] getUserList(){
        QueryDao qy=new QueryImpl();
        return qy.getList();
    }
}
