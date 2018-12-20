package com.dbsd6th.dao;

import com.dbsd6th.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    public int deleteByPrimaryKey(Integer id);
    /*这个函数的意思是通过对象的主键来删除数据，因为主键是唯一不变的
     *所以我们只要知道了主键，就能使用这个方法来删除数据库里的那条数
     *据，返回值是int，0是失败，1是成功*/

    public int insert(User record);
    /*这个函数的意思是向数据库里插入数据，参数就是这个类的对象，要注意的是，
     *想要成功的插入数据，那么在插入的时候，所有数据库设置为非空的属性，
     *我们都要在对象里设置好，比如user有name、create_time两个非空属性，如果不想赋值，
     *必须填null，才能成功insert，而id一般是int自增的，所以不设置，返回值是int，0是失败，1是成功
     */

    public int insertSelective(User record);
    /*这个函数跟上面那个差不多，都是插入，有区别的是它插入的时候加上了判断，
     *如果某个属性为NULL，则插入数据库的时候，那个属性不赋值；
     *而上面那个insert（）函数却是在插入的时候把所有的属性都赋值给数据库，
     *null也赋值为null，两个实际效果是一样的*/

    public User selectByPrimaryKey(Integer id);
    /*这个函数的意思是通过主键获得对应数据，输入对象的id，然后就能获得这个对象的具体信息，
      查询成功的话返回对象，失败的话返回null*/

    public int updateByPrimaryKeySelective(User record);
    /*这个函数的意思是通过主键来更新，且只有record里面不是null的属性，才能对数据库进行更新操作，
    比如说，我现在数据库里有这么一条数据User(id=1,name=lxf,password=123456)，
    我现在想对他进行更新record(id=1,name=lxf123,password=null)，执行函数，
    那么数据库里的记录将变为User(id=1,name=lxf123,password=123456)
    */

    public int updateByPrimaryKey(User record);
    /*这个函数的意思是通过主键来更新，且record里面的所有属性都将对数据库进行更新操作，
    比如说，我现在数据库里有这么一条数据User(id=1,name=lxf,password=123456)，
    我现在想对他进行更新record(id=1,name=lxf123,password=null)，执行函数，
    那么数据库里的记录将变为User(id=1,name=lxf123,password=null)
    */
    User selectByEmailOrPhone(User user);

    int updateByIdentityNumSelective(User user);

    int deleteUserByIdentityNum(String identityNum);
}