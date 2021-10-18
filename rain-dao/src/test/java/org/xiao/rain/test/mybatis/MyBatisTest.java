package org.xiao.rain.test.mybatis;

/**
 * Author: xiaojl
 * Date: 2021/8/3 23:57
 */
public class MyBatisTest {
    
//    @Test
//    public void testMyBatisQuery() {
//        SqlSession session = BaseDao.getInstance().getSqlSession();
//        IRainQueryDao dao = session.getMapper(IRainQueryDao.class);
//        List<UserVo> userVos = dao.queryUserVos();
//        for (UserVo userVo : userVos) {
//            System.out.println(userVo);
//        }
//    }
//    
//    @Test
//    public void testMyBatisInsert() {
//        SqlSession session = BaseDao.getInstance().getSqlSession();
//        IRainQueryDao dao = session.getMapper(IRainQueryDao.class);
//        UserVo vo = new UserVo();
//        vo.setPk_user("test00001");
//        vo.setVusercode("test00001");
//        vo.setVusername("test00001");
//        vo.setVpassword("test00001");
//        dao.insertUser(vo);
//        session.commit();
//        session.close();
//    }
//    
//    @Test
//    public void testQueryByCond() {
//        SqlSession session = BaseDao.getInstance().getSqlSession();
//        IRainQueryDao dao = session.getMapper(IRainQueryDao.class);
//        UserVo user = dao.queryUserByUserName("肖金龙");
//        System.out.println(user);
//        session.close();
//    }
//    
//    @Test
//    public void testMultiParams() {
//        SqlSession session = BaseDao.getInstance().getSqlSession();
//        IRainQueryDao dao = session.getMapper(IRainQueryDao.class);
//        List<UserVo> userVos = dao.queryUserVosByMultiParams("肖金龙", "xiaojl");
//        for (UserVo userVo : userVos) {
//            System.out.println(userVo);
//        }
//        session.close();
//    }
//    
//    @Test
//    public void testMultiByQueryParam() {
//        SqlSession session = BaseDao.getInstance().getSqlSession();
//        IRainQueryDao dao = session.getMapper(IRainQueryDao.class);
//        QueryParam param = new QueryParam();
//        param.setVname("肖金龙");
//        param.setVcode("xiaojl");
//        List<UserVo> userVos = dao.queryUserVosByQueryParams(param);
//        for (UserVo userVo : userVos) {
//            System.out.println(userVo);
//        }
//        session.close();
//    }
//    
//    @Test
//    public void testArg() {
//        SqlSession session = BaseDao.getInstance().getSqlSession();
//        IRainQueryDao dao = session.getMapper(IRainQueryDao.class);
//        List<UserVo> userVos = dao.queryUserVosByArg("xiaojl", "肖金龙");
//        for (UserVo userVo : userVos) {
//            System.out.println(userVo);
//        }
//        session.close();
//    }
//    
//    @Test
//    public void testMultiParamsMap() {
//        SqlSession session = BaseDao.getInstance().getSqlSession();
//        IRainQueryDao dao = session.getMapper(IRainQueryDao.class);
//        //key:  value:
//        Map<String, Object> paramMap = new HashMap<String, Object>();
//        paramMap.put("myname", "肖金龙");
//        paramMap.put("mycode", "xiaojl");
//        List<UserVo> userVos = dao.queryUsersByMap(paramMap);
//        for (UserVo userVo : userVos) {
//            System.out.println(userVo);
//        }
//        session.close();
//    }
//    
//    @Test
//    public void testReturnMap() {
//        SqlSession session = BaseDao.getInstance().getSqlSession();
//        IRainQueryDao dao = session.getMapper(IRainQueryDao.class);
//        List<Map<String, Object>> map = dao.queryUserResultTypeIsMap("肖%");
//        for (Map<String, Object> stringObjectMap : map) {
//        for (String column : stringObjectMap.keySet()) {
//            System.out.println(column);
//            System.out.println(stringObjectMap.get(column));
//        }
//            
//        }
//        session.close();
//    }
//    
//    @Test
//    public void testResultMap() {
//        SqlSession session = BaseDao.getInstance().getSqlSession();
//        IRainQueryDao dao = session.getMapper(IRainQueryDao.class);
//        List<UserVo> uservos = dao.queryUsersByResultMap("肖金龙");
//        for (UserVo uservo : uservos) {
//            System.out.println(uservo);
//        }
//        session.close();
//    }
//    
//    @Test
//    public void testDifferentColumn() {
//        SqlSession session = BaseDao.getInstance().getSqlSession();
//        IRainQueryDao dao = session.getMapper(IRainQueryDao.class);
//        List<MyUserVo> myUserVos = dao.queryUsersByDiffColumnName();
//
//        for (MyUserVo myUserVo : myUserVos) {
//            System.out.println(myUserVo);
//        }
//        
//        session.close();
//    }
//    
//    @Test
//    public void testMyBatisLike() {
//        SqlSession session = BaseDao.getInstance().getSqlSession();
//        IRainQueryDao dao = session.getMapper(IRainQueryDao.class);
//        PageHelper.startPage(2, 3);
//        List<UserVo> userVos = dao.queryUsersByLike("肖");
//        for (UserVo userVo : userVos) {
//            System.out.println(userVo);
//        }
//        session.close();
//    }
//    
//    @Test
//    public void testIf() {
//        SqlSession session = BaseDao.getInstance().getSqlSession();
//        IRainQueryDao dao = session.getMapper(IRainQueryDao.class);
//        UserVo vo = new UserVo();
////        vo.setVusername("肖金龙");
//        List<UserVo> userVos = dao.queryUsersByIf(vo);
//        for (UserVo userVo : userVos) {
//            System.out.println(userVo);
//        }
//        session.close();
//    }
//    
//    @Test
//    public void testWhere() {
//        SqlSession session = BaseDao.getInstance().getSqlSession();
//        IRainQueryDao dao = session.getMapper(IRainQueryDao.class);
//        UserVo vo = new UserVo();
////        vo.setVusername("肖金龙");
//        vo.setVusercode("xiaojl");
//        List<UserVo> userVos = dao.queryUserByWhereCond(vo);
//        for (UserVo userVo : userVos) {
//            System.out.println(userVo);
//        }
//        
//        session.close();
//    }
//    
//    @Test
//    public void testMyBatisForEach() {
//        SqlSession session = BaseDao.getInstance().getSqlSession();
//        IRainQueryDao dao = session.getMapper(IRainQueryDao.class);
//        List<String> userList = new ArrayList<>();
//        userList.add("肖金龙");
//        userList.add("肖雨桐");
//
//        List<UserVo> userVos = dao.queryUsersByList(userList);
//
//        for (UserVo userVo : userVos) {
//            System.out.println(userVo);
//        }
//        
//        session.close();
//
//    }
}
