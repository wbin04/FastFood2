package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.BO.CartService;
import Model.BO.FoodService;
import Model.BO.PromoService;
import Model.Bean.Cart;
import Model.Bean.Food;
import Model.Bean.Item;
import Model.Bean.Promo;

@WebServlet(urlPatterns = "/promo")
public class PromoServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CartService cartService = new CartService();
		HttpSession session = req.getSession(true);
		if(session.getAttribute("userId") != null) {
			int userId = (Integer)session.getAttribute("userId");
			Cart cart = cartService.getCartByUserId(userId);
			List<Item> listItem = cartService.getItemFood(cart.getId());
			req.setAttribute("listItem", listItem);
			int soLuong = cartService.getCartTotalQuantity(cart.getId());
			req.setAttribute("cartSize", soLuong);
		}
		PromoService promoService = new PromoService();
		List<Promo> listAvailablePromo = promoService.getAvailablePromo();
		req.setAttribute("listAvailablePromo", listAvailablePromo);
		List<Promo> listSoonPromo = promoService.getSoonPromo();
		req.setAttribute("listSoonPromo", listSoonPromo);
		req.getRequestDispatcher("promo.jsp").forward(req, resp);
	}
}
