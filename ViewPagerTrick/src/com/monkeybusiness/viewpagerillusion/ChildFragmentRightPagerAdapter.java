package com.monkeybusiness.viewpagerillusion;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ChildFragmentRightPagerAdapter extends FragmentPagerAdapter 
{
	List<ChildFragment> fragments = new ArrayList<ChildFragment>();

	public ChildFragmentRightPagerAdapter(FragmentManager fm) 
	{
		super(fm);
		
		initializeChilds();
	}

	private void initializeChilds() 
	{
		fragments.add(new ChildFragment(Color.CYAN,		"1"));
		fragments.add(new ChildFragment(Color.GREEN,	"2"));
		fragments.add(new ChildFragment(Color.MAGENTA,	"3"));
	}

	@Override
	public Fragment getItem(int index) 
	{
		return fragments.get(index);
	}

	/* (non-Javadoc)
	 * @see android.support.v4.view.PagerAdapter#getItemPosition(java.lang.Object)
	 */
	@Override
	public int getItemPosition(Object object) 
	{
		return fragments.indexOf(object);
	}

	@Override
	public int getCount() 
	{
		return (fragments == null)?(0):(fragments.size());
	}
}