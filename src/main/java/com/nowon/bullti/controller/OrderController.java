package com.nowon.bullti.controller;

import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nowon.bullti.domain.dto.order.BuyerInfoDTO;
import com.nowon.bullti.domain.dto.order.MemberOrderDTO;
import com.nowon.bullti.domain.dto.payment.PaySaveDTO;
import com.nowon.bullti.domain.dto.payment.payCompleteDTO;
import com.nowon.bullti.service.MemberService;
import com.nowon.bullti.service.OrderService;
import com.nowon.bullti.service.PayService;
import com.nowon.bullti.utils.AuthenUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class OrderController {
	
	private final MemberService memberService;
	
	private final PayService payservice;
	
	private final OrderService orderService;
	
	@GetMapping("/orders")
	public String order(Model model, Authentication authentication) {
		
		long MemberNo = AuthenUtils.extractMemberNo(authentication);
		MemberOrderDTO dto= orderService.getOrderInfo(MemberNo);
		
		model.addAttribute("dto", dto);
		return "order/order";
	}
	
	@GetMapping("/my/orders")
	//Authentication authentication
	public String orderList(Model model) {
		//MyUser user = (MyUser) authentication.getPrincipal();
		//Member member = memberService.getFindById(user.getMemberNo());
		
		
		return "order/list";
	}
	
	/**
	 * 주문
	 * @return 주문번호
	 */
	@ResponseBody
	@PostMapping("/orders")
	public Long orders(Authentication authentication) {
		
		long MemberNo = AuthenUtils.extractMemberNo(authentication);
		Long orderNo = orderService.save(MemberNo);

		return orderNo;
	}
	
	/**
	 * 결제자 정보
	 * @return
	 */
	@ResponseBody
	@GetMapping("/orders/members")
	public BuyerInfoDTO orderMember(Authentication authentication) {
		
		long MemberNo = AuthenUtils.extractMemberNo(authentication);
		BuyerInfoDTO dto = orderService.getBuyerInfo(MemberNo);
		return dto;
	}
	
	/**
	 * 결제정보 DB 등록
	 * @param body
	 */
	@ResponseBody
	@PostMapping("/orders/payments")
	public void paySaveDb(@RequestBody PaySaveDTO dto) {
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
	@GetMapping("/orders/payments/complete/{orderNo}")
	//Authentication authentication
	public String complete(@RequestParam(name = "imp_uid") String imp_uid,
			@RequestParam(name = "merchant_uid") String merchant_uid,
			@RequestParam(name = "imp_success") boolean imp_success,
			@RequestParam(name = "error_code", required = false) String error_code,
			@RequestParam(name = "error_msg", required = false) String error_msg,
			RedirectAttributes attributes,
			@PathVariable(name = "orderNo") Long orderNo
			) {
		
		// 결제 성공 여부 정수
		int no;
		// 결제 성공 실패
		if(!imp_success) {
			attributes.addAttribute("error_code", error_code);
			attributes.addAttribute("error_msg", error_msg);
			no = 0;
		}else {
			// 사후 유효성 검사 생략
			no = 1;
		}
		orderService.complete(orderNo, no);
		return "redirect:/";
	}
	
	/**
	 * no : 1=성공, 0=실패
	 * @param dto
	 */
	@ResponseBody
	@PostMapping("/orders/payments/complete/{no}")
	public void completePc(@RequestBody(required = false) payCompleteDTO dto, @PathVariable(name = "no") int no) {
		// 사후 유효성 검사 생략
		orderService.complete(dto.getOrderNo(), no);
	}
	
	/**
	 * 결제 금액 사전 등록
	 * @param body {merchant_uid, amount}
	 */
	@ResponseBody
	@PostMapping("/orders/payments/prepare")
	public void postMethodName(@RequestBody Map<String, Object> body) {
		payservice.prepare(body);
	}
}
