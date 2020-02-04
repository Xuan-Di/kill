package com.wzxlq.kill.server.service;

import com.wzxlq.kill.model.entity.ItemKill;

import java.util.List;

/**
 * @author 王照轩
 * @date 2020/2/2 - 16:51
 */
public interface IItemService {
     List<ItemKill> getKillItems() throws Exception;
     ItemKill getKillDetail(Integer id) throws Exception;
}
