package com.nowon.bullti.chatbot.bus;

import lombok.Data;

@Data
public class StationItem {
	
	private String stationId;          // "109000149"    //정류소 ID
	private String stationNm;          // "창4동주민센터"   //정류소명
	private String gpsX;          // "127.0523314066"    //정류소 좌표X (WGS84)
	private String gpsY;          // "37.6525121272"     //정류소 좌표Y (WGS84)
	private String posX;          // "204617.4067366653" //정류소 좌표X (GRS80)
	private String posY;          // "461436.63330844464"//정류소 좌표Y (GRS80)
	private String stationTp;          // "1"            //정류소타입 (0:공용, 1:일반형 시내/농어촌버스, 2:좌석형 시내/농어촌버스, 3:직행좌석형 시내/농어촌버스, 4:일반형 시외버스, 5:좌석형 시외버스, 6:고속형 시외버스, 7:마을버스)
	private String arsId;          // "10235" //정류소고유번호
	private String dist;          // "39"     //거리

}
