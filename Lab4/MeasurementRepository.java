package vjezba4.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vjezba4.demo.Models.Client;
import vjezba4.demo.Models.Measurements;

@Repository
public interface MeasurementRepository  extends JpaRepository<Measurements,String>{
		public default Measurements add(Measurements m)
		{
			m.setId(m.getId());
			m.setYear(m.getYear());
			m.setMonth(m.getMonth());
			m.setResult(m.getResult());
			
			return m;
			
		}
}
