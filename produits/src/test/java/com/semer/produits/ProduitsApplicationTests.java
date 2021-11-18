package com.semer.produits;

import java.util.List;

import com.semer.produits.entities.Categorie;
import com.semer.produits.entities.Produit;
import com.semer.produits.repos.ProduitRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProduitsApplicationTests {
	@Autowired
	private ProduitRepository produitRepository;

	/*
	 * @Test public void testCreateProduit() { Produit prod = new
	 * Produit("PC DELL ", 2200.500, new Date()); produitRepository.save(prod); }
	 */

	/*
	 * @Test public void testFindProduit() { Produit p =
	 * produitRepository.findById(1L).get(); System.out.println(p); }
	 */

	@Test
	public void testUpdateProduit() {
		Produit p = produitRepository.findById(1L).get();
		p.setPrixProduit(1000.0);
		produitRepository.save(p);
	}

	/*
	 * @Test public void testDeleteProduit() { produitRepository.deleteById(2L); }
	 */

	@Test
	public void testListerTousProduits() {
		List<Produit> prods = produitRepository.findAll();
		for (Produit p : prods) {
			System.out.println(p);
		}
	}

	@Test
	void testFindByNomProduit() {
		List<Produit> prods = produitRepository.findByNomProduit("iphone x");
		for (Produit p : prods) {
			System.out.println(p);
		}
	}

	@Test
	public void testFindByNomProduitContains() {
		List<Produit> prods = produitRepository.findByNomProduitContains("iphone x");
		for (Produit p : prods) {
			System.out.println(p);
		}
	}

	@Test
	public void testFindNomPrix() {
		List<Produit> prods = produitRepository.findByNomPrix("iphone x", 1000.0);
		for (Produit p : prods) {
			System.out.println(p);
		}
	}

	@Test
	public void testfindByCategorie() {
		Categorie cat = new Categorie();
		cat.setIdCat(1L);
		List<Produit> prods = produitRepository.findByCategorie(cat);
		for (Produit p : prods) {
			System.out.println(p);
		}

	}

	@Test
	public void findByCategorieIdCat() {
		List<Produit> prods = produitRepository.findByCategorieIdCat(1L);
		for (Produit p : prods) {
			System.out.println(p);
		}
	}

	@Test
	public void testfindByOrderByNomProduitAsc() {
		List<Produit> prods = produitRepository.findByOrderByNomProduitAsc();
		for (Produit p : prods) {
			System.out.println(p);
		}
	}

	@Test
	public void testTrierProduitsNomsPrix() {
		List<Produit> prods = produitRepository.trierProduitsNomsPrix();
		for (Produit p : prods) {
			System.out.println(p);
		}
	}

}
