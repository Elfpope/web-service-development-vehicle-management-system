<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:param name="currentlyLoggedIn" />
	<xsl:param name="userRole" />
	
	<xsl:template match="/">
		<ul class="breadcrumb" style="margin-top: 75px;">
			<li class="active">Home</li>
		</ul>

		<div class="jumbotron">
			<h1>Vehicle Management System</h1>
			<p>
				Welcome to the Vehicle Management System!
			</p>
		</div>
		<div class="container">
			<h1>List of Vehicles</h1>
			
			<xsl:if test="$currentlyLoggedIn = 'true' and $userRole = 'Administrator'  ">
					
					<a href="#" type="button" class="btn btn-info btn-sm"
						data-toggle="modal" data-target="#addVehicleModal">
						Add a new vehicle
						<span class="glyphicon glyphicon-plus"></span>
					</a>
					
				</xsl:if>
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>Registration Number</th>
						<th>Type</th>
						<th>Make</th>
						<th>Model</th>
						<th>Colour</th>
						<th>Kilometres travelled</th>
					</tr>
				</thead>
				<tbody>
					<xsl:apply-templates />
				</tbody>
			</table>
		</div>
	</xsl:template>

	<xsl:template match="vehicle">
		<tr>
			<td>
				<a href="vehicle.jsp?regoNumber={regoNumber}">
					<xsl:value-of select="regoNumber" />
				</a>
			</td>
			<xsl:apply-templates />
		</tr>
	</xsl:template>

	<xsl:template match="vehicleType|make|model|colour|kilometres">
		<td>
			<xsl:apply-templates />
		</td>
	</xsl:template>

	<xsl:template match="regoNumber|trip" />

</xsl:stylesheet>