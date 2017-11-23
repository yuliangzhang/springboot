package com.reptile.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.websocket.EncodeException;
import javax.websocket.Session;

import net.sf.json.JSONObject;

public class PushSocket {
	/**
	 * 0001 失败 0000 成功
	 * @param map
	 * @param UUID
	 * @param errorInfo
	 */
	public static void push(Map<String, Object> map,String UUID,String errorInfo){
		Map<String, Object> mapData=new HashMap<String, Object>();
		Session se=	talkFrame.getWsUserMap().get(UUID);
		String seq_id=talkFrame.getWsInfoMap().get(UUID);
		System.out.println(se);
		System.out.println(seq_id);
		try {
//			mapData.put("resultCode", errorInfo);
//			mapData.put("seq_id", seq_id);
//			JSONObject json=JSONObject.fromObject(mapData);
			se.getBasicRemote().sendText("{\"resultCode\":"+errorInfo+",\"seq_id\":"+seq_id+"}");
		
			//se.getBasicRemote().sendObject(json);
			
		} catch (Exception e) {
			  map.put("errorCode", "0001");
			  map.put("errorInfo", "网络异常");
			e.printStackTrace();
		}
		
	}

}