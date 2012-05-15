package com.monkeybusiness.viewpagerillusion;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ChildFragment extends Fragment 
{
	ViewGroup childView;
	int color;
	String label;
	
	public ChildFragment()
	{
		
	}
	
	public ChildFragment(int color, String label)
	{
		this.color = color;
		this.label = label;
	}
	
	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
	{
		//Try to inflate layout
		childView = (ViewGroup) inflater.inflate(R.layout.child, container, false);
		//Set background
		childView.setBackgroundColor(color);
		//Stamp fragment with its label
		((TextView) childView.findViewById(R.id.text)).setText(label);
		
		//return root view to be displayed as GUI component
		return childView;
	}

	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onDestroyView()
	 */
	@Override
	public void onDestroyView() 
	{
		super.onDestroyView();
		
		//TODO destroy the childView and it's sub components here
	}
}
