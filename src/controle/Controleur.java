package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.*;
import dao.Service;
import meserreurs.*;

/**
 * Servlet implementation class Controleur
 */
@WebServlet("/Controleur")
public class Controleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ACTION_TYPE = "action";
	private static final String LISTER_ADHERENT = "listerAdherent";
	private static final String AJOUTER_ADHERENT = "ajouterAdherent";
	private static final String INSERER_ADHERENT = "insererAdherent";
	private static final String ERROR_KEY = "messageErreur";
	private static final String ERROR_PAGE = "/erreur.jsp";

	private static final String GERER_OEUVRES = "gererOeuvres";
	private static final String SE_CONNECTER = "seConnecter";
	private static final String HOME = "home";
	private static final String AJOUTER_OEUVRE = "ajouterOeuvre";
	private static final String INSERER_OEUVRE = "insererOeuvre";
	private static final String LISTER_OEUVRE = "listerOeuvre";
	private static final String MODIFIER_OEUVRE = "modifierOeuvre";
	private static final String SAUVEGARDER_OEUVRE = "sauvegarderOeuvre";
	private static final String RESERVER_OEUVRE = "reserverOeuvre";
	private static final String GERER_RESERVATIONS = "gererReservations";
	private static final String SE_DECONNECTER = "seDeconnecter";



	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controleur() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processusTraiteRequete(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processusTraiteRequete(request, response);
	}

	protected void processusTraiteRequete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String actionName = request.getParameter(ACTION_TYPE);
		String destinationPage = ERROR_PAGE;
		// execute l'action
		if (LISTER_ADHERENT.equals(actionName)) {
			try {
				Service unService = new Service();
				request.setAttribute("mesAdherents", unService.consulterListeAdherents());
			} catch (MonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			destinationPage = "/listerAdherent.jsp";
		}

		else if (AJOUTER_ADHERENT.equals(actionName)) {
			destinationPage = "/ajouterAdherent.jsp";
		}

		else if (INSERER_ADHERENT.equals(actionName)) {
			try {
				Adherent unAdherent = new Adherent();
				unAdherent.setNomAdherent(request.getParameter("txtnom"));
				unAdherent.setPrenomAdherent(request.getParameter("txtprenom"));
				unAdherent.setVilleAdherent(request.getParameter("txtville"));
				Service unService = new Service();
				unService.insertAdherent(unAdherent);

			} catch (MonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			destinationPage = "/index.jsp";
		}

		else if (GERER_OEUVRES.equals(actionName)) {
			destinationPage = "/GestionDesOeuvres/seConnecter.jsp";
		}

		else if(SE_CONNECTER.equals(actionName)) {
			Boolean canConnect = false;
			try {
				Service unService = new Service();
				canConnect = unService.seConnecter(request.getParameter("username"), request.getParameter("password"));
			} catch (MonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(canConnect)
				destinationPage="/GestionDesOeuvres/home.jsp";
			else
				destinationPage="/GestionDesOeuvres/seConnecter.jsp";
		}

		else if (HOME.equals(actionName)) {
			destinationPage = "/GestionDesOeuvres/home.jsp";
		}

		else if (AJOUTER_OEUVRE.equals(actionName)) {
			try {

				Service unService = new Service();
				request.setAttribute("proprietaires", unService.listeProprietaires());

			} catch (MonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			destinationPage = "/GestionDesOeuvres/ajouterOeuvre.jsp";
		}

		else if (INSERER_OEUVRE.equals(actionName)) {
			try {
				Oeuvrevente uneOeuvre = new Oeuvrevente();
				uneOeuvre.setTitreOeuvrevente(request.getParameter("txttitre"));
				uneOeuvre.setEtatOeuvrevente("L");
				uneOeuvre.setPrixOeuvrevente(Float.parseFloat(request.getParameter("txtprix")));
				Service unService = new Service();
				Proprietaire myP = unService.rechercherProprietaire(request.getParameter("txtpropietaire"));
				uneOeuvre.setProprietaire(myP);
				unService.insertOeuvre(uneOeuvre);

			} catch (MonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			destinationPage = "/GestionDesOeuvres/home.jsp";
		}

		else if (LISTER_OEUVRE.equals(actionName)) {
			try {
				Service unService = new Service();
				request.setAttribute("mesOeuvres", unService.consulterListeOeuvres());
			} catch (MonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			destinationPage = "/GestionDesOeuvres/listerOeuvre.jsp";
		}

		else if (MODIFIER_OEUVRE.equals(actionName)){
			try{
				Service unS = new Service();
				Oeuvrevente uneO = unS.rechercherOeuvreIdParam(Integer.parseInt(request.getParameter("modif")));
				request.setAttribute("oeuvreAModifier", uneO);
				request.setAttribute("proprietaires", unS.listeProprietaires());
			} catch (MonException e){
				e.printStackTrace();
			}
			destinationPage = "/GestionDesOeuvres/gererOeuvre.jsp";
		}

		else if (SAUVEGARDER_OEUVRE.equals(actionName)){
			try {
				Service unService = new Service();
				Oeuvrevente uneOeuvre = unService.rechercherOeuvreIdParam(Integer.parseInt(request.getParameter("txtIDOeuvre")));
				uneOeuvre.setTitreOeuvrevente(request.getParameter("txttitre"));
				uneOeuvre.setEtatOeuvrevente("L");
				uneOeuvre.setPrixOeuvrevente(Float.parseFloat(request.getParameter("txtprix")));
				Proprietaire myP = unService.rechercherProprietaire(request.getParameter("txtpropietaire"));
				uneOeuvre.setProprietaire(myP);
				unService.updateOeuvre(uneOeuvre);

			} catch (MonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			destinationPage = "/GestionDesOeuvres/home.jsp";
		}

		else if (GERER_RESERVATIONS.equals(actionName)) {
			destinationPage = "/GestionDesOeuvres/gererReservation.jsp";
		}

		else if (SE_DECONNECTER.equals(actionName)) {
			destinationPage = "/index.jsp";
		}

		else {
			String messageErreur = "[" + actionName + "] n'est pas une action valide.";
			request.setAttribute(ERROR_KEY, messageErreur);
		}
		// Redirection vers la page jsp appropriee
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destinationPage);
		dispatcher.forward(request, response);

	}

}
