package segmenti;


public class Segmenti {
		

		public int nextInt(int n) {
			   if (n <= 0)
			     throw new IllegalArgumentException("deve essere  positivo");

			   if ((n & -n) == n) 
			     return (int)((n * (long)nextInt(31)) >> 31);

			   int bits, val;
			   do {
			       bits = nextInt(31);
			       val = bits % n;
			   } while (bits - val + (n-1) < 0);
			   return val;
			 }
		
		public Punto creaPunto() {
			int x = nexInt(40);
			int y = nexInt(40);
			Punto p = new Punto(x,y);
			
			return p;
		}
		public Punto creaSegmento(Punto p1) {
			int x = nexInt(40);
			int y = nexInt(40);
			Punto p2 = new Punto(x,y);
			Segmento s1 = new Segmento(p1,p2);
			
			return p2;
		}
		
		public static void main(String[] args) {
			Punto p1= null;
			Punto p2 = null;
		 Segmento segmenti[] = new Segmento[100] ;
			
			Segmenti Gseg = new Segmenti();
			
			int i=0;
			for (i=0;i<20;i++) {
				p1 = Gseg.creaPunto();
				p2= Gseg.creaSegmento(p1);
				segmenti[i].getpPrecedente()=p1;
				segmenti[i].getpCorrente()=p2;
			}
		}
}
