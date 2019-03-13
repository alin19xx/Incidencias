package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Codificable implements Comparable<Codificable>
{
	//TODO Hay que guardar el ultimo codigo para que no se vuelva a repetir
	private static long codigoNum;
	private String codigo;
	
	SimpleDateFormat sdf  = new SimpleDateFormat("yyyy");
	String currentYear = sdf.format(new Date());

	public Codificable(String codigo)
	{
		this.codigo = codigo;
	}

	protected Codificable()
	{
		codigo = getClass().getSimpleName().substring(0, 3) + (currentYear + codigoNum++);
	}

	public static Codificable buildCodificable(String codigo)
	{
		return new Codificable(codigo) {};
	}

	@Override
	public int compareTo(Codificable o)
	{
		return codigo.compareTo(o.codigo);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Codificable other = (Codificable)obj;
		if (codigo == null)
		{
			if (other.codigo != null)
				return false;
		}
		else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	public String getCodigo()
	{
		return codigo;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public String toString()
	{
		return "(" + getClass().getSimpleName() + " " + codigo + ")";
	}
}
