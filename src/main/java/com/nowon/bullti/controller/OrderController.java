package com.nowon.bullti.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nowon.bullti.BulltiOrderServiceApplication;
import com.nowon.bullti.domain.dto.order.OrderSaveDTO;
import com.nowon.bullti.domain.dto.payment.PaySaveDTO;
import com.nowon.bullti.domain.entity.basket.Basket;
import com.nowon.bullti.service.MemberService;
import com.nowon.bullti.service.OrderService;
import com.nowon.bullti.service.PayService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequiredArgsConstructor
@RequestMapping("/orders")
@Controller
public class OrderController {
	
	private final MemberService memberService;
	
	private final PayService payservice;
	
	private final OrderService orderService;
	
	
	@GetMapping("")
	//Authentication authentication
	public String order(Model model) {
		//MyUser user = (MyUser) authentication.getPrincipal();
		//Member member = memberService.getFindById(user.getMemberNo());
		
		
		return "order/order";
	}
	
	/**
	 * 주문
	 * @return 주문번호
	 */
	@ResponseBody
	@PostMapping("")
	//Authentication authentication
	public long orders() {
		//MyUser user = (MyUser) authentication.getPrincipal();
		//Member member = memberService.getFindById(user.getMemberNo());
		//Basket basket = BasketService.findById(member) 
		//orderService.save();

		long orderNo=0;
		return orderNo;
	}
	
	/**
	 * 결제자 정보
	 * @return
	 */
	@ResponseBody
	@GetMapping("/members")
	//Authentication authentication
	public Map<String, String> orderMember() {
		//MyUser user = (MyUser) authentication.getPrincipal();
		//Member member = memberService.getFindById(user.getMemberNo());
		
		Map<String, String> map = new HashMap<>();
		
		return map;
	}
	
	/**
	 * 결제정보 DB 등록
	 * @param body
	 */
	@PostMapping("/payments")
	public void paySaveDb(PaySaveDTO dto) {
		payservice.save(dto);
	}
	
	/**
	 * 결제완료
	 * @param imp_uid 포트원 결제 고유번호 ex) imp_172034826844
	 * @param merchant_uid 가맹점 주문번호 ex) IMP380
	 * @param imp_success 결제 성공 여부
	 * @param error_code 오류 코드 / 실패 시
	 * @param error_msg 오류 메세지 / 실패 시 ex) [결제포기] 사용자가 결제를 취소하셨습니다
	 * @param attributes
	 * @return
	 */
	@GetMapping("/payments/complete")
	//Authentication authentication
	public String complete(@RequestParam(name = "imp_uid") String imp_uid,
			@RequestParam(name = "merchant_uid") String merchant_uid,
			@RequestParam(name = "imp_success") boolean imp_success,
			@RequestParam(name = "error_code", required = false) String error_code,
			@RequestParam(name = "error_msg", required = false) String error_msg,
			RedirectAttributes attributes
			) {
		
		// 결제 성공 실패
		if(!imp_success) {
			attributes.addAttribute("error_code", error_code);
			attributes.addAttribute("error_msg", error_msg);
		}else {
			//유효성 검사 완료
			if(payservice.vaildate(imp_uid, merchant_uid)) {
				//DB상태 바꾸고 가게 메시지 보내기
				
			};
		}
		return "redirect:/";
	}
	
	/**
	 * 결제 금액 사전 등록
	 * @param body {merchant_uid, amount}
	 */
	@ResponseBody
	@PostMapping("/payments/prepare")
	public void postMethodName(@RequestBody Map<String, Object> body) {
		payservice.prepare(body);
	}
}
