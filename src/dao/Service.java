package dao;

import com.sun.org.apache.xml.internal.security.keys.storage.implementations.KeyStoreResolver;
import meserreurs.MonException;
import java.util.*;

import metier.*;
import persistance.*;

public class Service {

	// Mise à jour des caractéristiques d'un adhérent
	// Le booleen indique s'il s'agit d'un nouvel adhérent, auquel cas on fait
	// une création

	public void insertAdherent(Adherent unAdherent) throws MonException {
		String mysql;

		DialogueBd unDialogueBd = DialogueBd.getInstance();
		try {
			mysql = "insert into adherent  (nom_adherent,prenom_adherent,ville_adherent)  " + "values ('"
					+ unAdherent.getNomAdherent();
			mysql += "'" + ",'" + unAdherent.getPrenomAdherent() + "','" + unAdherent.getVilleAdherent() + "')";

			unDialogueBd.insertionBD(mysql);
		} catch (MonException e) {
			throw e;
		}
		catch (Exception exc) {
			throw new MonException(exc.getMessage(), "systeme");
		}
	}

	// gestion des adherents
	// Consultation d'un adhérent par son numéro
	// Fabrique et renvoie un objet adhérent contenant le résultat de la requête
	// BDD
	public Adherent consulterAdherent(int numero) throws MonException {
		
		 Map mParams = new HashMap();
	     Map mParam;
	  try
	  {
		String mysql = "select * from adherent where numero_adherent=?";
		 mParam = new HashMap();
	     mParam.put(1, numero);
	     mParams.put(0, mParam); 
		List<Adherent> mesAdh = consulterListeAdherents(mysql);
		if (mesAdh.isEmpty())
			return null;
		else {
			return mesAdh.get(0);
		}
	  } catch (MonException e)
		{
			throw e;
		}
	}

	// Consultation des adhérents
	// Fabrique et renvoie une liste d'objets adhérent contenant le résultat de
	// la requête BDD
	public List<Adherent> consulterListeAdherents() throws MonException {
		String mysql = "select * from adherent";
		return consulterListeAdherents(mysql);
	}

	private List<Adherent> consulterListeAdherents(String mysql) throws MonException {
		List<Object> rs;
		List<Adherent> mesAdherents = new ArrayList<Adherent>();
		int index = 0;
		try {
			DialogueBd unDialogueBd = DialogueBd.getInstance();
			rs =unDialogueBd.lecture(mysql);
			while (index < rs.size()) {
				// On crée un stage
				Adherent unA = new Adherent();
				// il faut redecouper la liste pour retrouver les lignes
				unA.setIdAdherent(Integer.parseInt(rs.get(index + 0).toString()));
				unA.setNomAdherent(rs.get(index + 1).toString());
				unA.setPrenomAdherent(rs.get(index + 2).toString());
				unA.setVilleAdherent(rs.get(index + 3).toString());
				// On incrémente tous les 3 champs
				index = index + 4;
				mesAdherents.add(unA);
			}

			return mesAdherents;
		} catch (MonException e) {
			throw e;
		}
		catch (Exception exc) {
			throw new MonException(exc.getMessage(), "systeme");
		}
	}
	
	
	public Oeuvrevente rechercherOeuvreIdParam(int id) throws MonException {
		String mysql = "";
		 Map mParams = new HashMap();
	     Map mParam;
	 	List<Object> rs;
		Oeuvrevente uneOeuvre=null;;
		try
		{
			mysql = "SELECT id_oeuvrevente, titre_oeuvrevente, etat_oeuvrevente,prix_oeuvrevente,id_proprietaire";
			mysql += " FROM Oeuvrevente WHERE id_Oeuvrevente = ? ";
		     mParam = new HashMap();
		     mParam.put(1, id);
		     mParams.put(0, mParam);  
		     rs=DialogueBd.getInstance().lectureParametree(mysql, mParams);
		     if (rs.size() > 0) {
					
					uneOeuvre = new Oeuvrevente();
					uneOeuvre.setIdOeuvrevente(Integer.parseInt(rs.get(0).toString()));
					uneOeuvre.setTitreOeuvrevente(rs.get(1).toString());
					uneOeuvre.setEtatOeuvrevente(rs.get(2).toString());
					uneOeuvre.setPrixOeuvrevente(Float.parseFloat(rs.get(3).toString()));
					int num = Integer.parseInt(rs.get(4).toString());
					// On appelle la recherche d'un propriétaire
					uneOeuvre.setProprietaire(rechercherProprietaire(num));
				}
		} 
		
		catch (MonException e)
		{
			throw e;
		}
		catch (Exception exc) {
			throw new MonException(exc.getMessage(), "systeme");
		}
		return uneOeuvre;
		
	}

	public List<Proprietaire> listeProprietaires() throws MonException{
		String mysql = "select * from proprietaire";
		List<Object> rs;
		List<Proprietaire> proprietaires = new ArrayList<>();
		int index = 0;
		try {
			DialogueBd unDialogueBd = DialogueBd.getInstance();
			rs =unDialogueBd.lecture(mysql);
			while (index < rs.size()) {
				Proprietaire unP = new Proprietaire();
				unP.setIdProprietaire(Integer.parseInt(rs.get(index + 0).toString()));
				unP.setNomProprietaire(rs.get(index + 1).toString());
				unP.setPrenomProprietaire(rs.get(index+2).toString());
				index += 3;
				proprietaires.add(unP);
			}
			return proprietaires;
		} catch (MonException e) {
			throw e;
		}
		catch (Exception exc) {
			throw new MonException(exc.getMessage(), "systeme");
		}
	}
	 
	public Proprietaire rechercherProprietaire(int  id) throws MonException {
		 Map mParams = new HashMap();
	     Map mParam;
	 	List<Object> rs;
		Proprietaire  unProprietaire=null;
		String mysql = " select * from Proprietaire where id_Proprietaire=?";
		try 
		{
			 mParam = new HashMap();
		     mParam.put(1, id);
		     mParams.put(0, mParam);  
		     rs=DialogueBd.getInstance().lectureParametree(mysql, mParams);
			if (rs.size() > 0) {
				unProprietaire = getProprietaire(rs);
			}
		}

		catch (MonException e) {
			throw e;
		}
		catch (Exception exc) {
			throw new MonException(exc.getMessage(), "systeme");
		}
		return unProprietaire;
	}
	public Proprietaire rechercherProprietaire(String  nom) throws MonException {
		Map mParams = new HashMap();
		Map mParam;
		List<Object> rs;
		Proprietaire  unProprietaire=null;
		String requete = " select * from Proprietaire where nom_proprietaire=?";
		try
		{
			mParam = new HashMap();
			mParam.put(1, nom);
			mParams.put(0, mParam);
			rs=DialogueBd.getInstance().lectureParametree(requete, mParams);
			if (rs.size() > 0) {
				unProprietaire=getProprietaire(rs);
			}
		}

		catch (MonException e) {
			throw e;
		}
		catch (Exception exc) {
			throw new MonException(exc.getMessage(), "systeme");
		}
		return unProprietaire;
	}
	private Proprietaire getProprietaire(List<Object> rs){
		Proprietaire unProprietaire = new Proprietaire();
		unProprietaire.setIdProprietaire(Integer.parseInt(rs.get(0).toString()));
		unProprietaire.setNomProprietaire(rs.get(1).toString());
		unProprietaire.setPrenomProprietaire(rs.get(2).toString());
		return unProprietaire;
	}

	public void insertOeuvre(Oeuvrevente uneOeuvre) throws MonException {
		String mysql;

		DialogueBd unDialogueBd = DialogueBd.getInstance();
		try {
			mysql = "insert into oeuvrevente (titre_oeuvrevente, etat_oeuvrevente, prix_oeuvrevente,id_proprietaire)" + "values ('"
					+ uneOeuvre.getTitreOeuvrevente();
			mysql += "' ,'" + uneOeuvre.getEtatOeuvrevente() + "','" + uneOeuvre.getPrixOeuvrevente()+ "','" + uneOeuvre.getProprietaire().getIdProprietaire() + "')";

			unDialogueBd.insertionBD(mysql);
		} catch (MonException e) {
			throw e;
		}
		catch (Exception exc) {
			throw new MonException(exc.getMessage(), "systeme");
		}
	}

	public List<Oeuvrevente> consulterListeOeuvres() throws MonException {
		String mysql = "select * from oeuvrevente";
		return consulterListeOeuvres(mysql);
	}
	private List<Oeuvrevente> consulterListeOeuvres(String mysql) throws MonException {
		List<Object> rs;
		List<Oeuvrevente> mesOeuvres = new ArrayList<>();
		int index = 0;
		try {
			DialogueBd unDialogueBd = DialogueBd.getInstance();
			rs =unDialogueBd.lecture(mysql);
			while (index < rs.size()) {
				// On crée un stage
				Oeuvrevente uneO = new Oeuvrevente();
				// il faut redecouper la liste pour retrouver les lignes
				uneO.setIdOeuvrevente(Integer.parseInt(rs.get(index + 0).toString()));
				uneO.setTitreOeuvrevente(rs.get(index + 1).toString());
				uneO.setEtatOeuvrevente(rs.get(index + 2).toString());
				uneO.setPrixOeuvrevente(Float.parseFloat(rs.get(index + 3).toString()));
				uneO.setProprietaire(rechercherProprietaire(Integer.parseInt(rs.get(index + 4).toString())));
				// On incrémente tous les 5 champs
				index = index + 5;
				mesOeuvres.add(uneO);
			}

			return mesOeuvres;
		} catch (MonException e) {
			throw e;
		}
		catch (Exception exc) {
			throw new MonException(exc.getMessage(), "systeme");
		}
	}

	public boolean seConnecter(String user, String password) throws MonException {
		Map mParams = new HashMap();
		Map mParam;
		List<Object> rs;
		Boolean canLogin = false;

		try {
			if (user != null && password != null) {
				String mysql = "Select * from adherent Where nom_adherent=? and prenom_adherent=?";
				mParam = new HashMap();
				mParam.put(1, user);
				mParam.put(2, password);
				mParams.put(0, mParam);
				rs=DialogueBd.getInstance().lectureParametree(mysql, mParams);
				if (rs.size() > 0) {
					canLogin = true;
				}
			}
		}
		catch (MonException e)
			{
				throw e;
			}
		catch (Exception exc) {
				throw new MonException(exc.getMessage(), "systeme");
			}
			return canLogin;
	}

}
