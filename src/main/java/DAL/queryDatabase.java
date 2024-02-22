/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAL;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 * @param <T>
 */
public interface queryDatabase<T> {
    public List<T> selectAll();
	
	public T selectById(T t);
	
	public int insert(T t);
	
	public int insertAll(List<T> arr);
	
	public int delete(T t);
	
	public int deleteAll(List<T> arr);
	
	public int update(T t);
}
