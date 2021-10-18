package org.xiao.rain.service.impl;

import org.springframework.stereotype.Service;
import org.xiao.rain.dao.itf.IGoodDao;
import org.xiao.rain.dao.itf.IOrderDao;
import org.xiao.rain.exception.BusinessException;
import org.xiao.rain.service.itf.IBuyGoodBusiness;
import org.xiao.rain.vo.good.GoodVo;
import org.xiao.rain.vo.order.OrderVo;

import javax.annotation.Resource;

/**
 * Author: xiaojl
 * Date: 2021/8/10 07:30
 */
@Service("buyGoodService")
public class IBuyGoodBusinessImpl implements IBuyGoodBusiness {
    @Resource(name = "IGoodDao")
    private IGoodDao iGoodDao;
    @Resource(name = "IOrderDao")
    private IOrderDao iOrderDao;
    @Resource(name = "buyGoodService")
    private IBuyGoodBusiness iBuyGoodBusiness;

//    public void setiGoodDao(IGoodDao iGoodDao) {
//        this.iGoodDao = iGoodDao;
//    }
//
//    public void setiOrderDao(IOrderDao iOrderDao) {
//        this.iOrderDao = iOrderDao;
//    }

    @Override
//    @Transactional(
//            propagation = Propagation.REQUIRED,
//            isolation = Isolation.DEFAULT,
//            readOnly = false,
//            rollbackFor = {
//                    BusinessException.class
//            }
////            noRollbackFor = {
////                    RuntimeException.class
////            }
//            
//    )
    public void buy(Integer pk_good, int nnum) throws BusinessException {
        OrderVo order = new OrderVo();
        order.setPk_good(pk_good);
        order.setNnum(nnum);
        iOrderDao.insetOrder(order);
        
        try {
//            iBuyGoodBusiness.buy2(pk_good, nnum);
        } catch (Exception e) {
//            e.printStackTrace();
        }
//            GoodVo good = iBuyGoodBusiness.query_RequiresNew(pk_good);
//            if(good.getNnum() < nnum) {
//                throw new RuntimeException("库存不足");
//            }
//      
//        good.setNnum(good.getNnum() - nnum);
//        iGoodDao.updateGood(good);
    }

    @Override
    public void buy2(Integer pk_good, int nnum) throws BusinessException {
        if(true) {
            throw new BusinessException("122");
        }
    }

    public GoodVo query_RequiresNew(Integer pk_good) throws BusinessException {
        GoodVo good = iGoodDao.queryGoodByPk(pk_good);
        
        if(good == null) {
            good = new GoodVo();
            good.setVname("good" + pk_good);
            good.setNnum(pk_good);
            good.setNprice(100.1f);
//            throw new BusinessException("requirednew没有库存编号为：" + pk_good + "的商品");
             iGoodDao.insertGood(good);
        }
        return good;
    }
}
