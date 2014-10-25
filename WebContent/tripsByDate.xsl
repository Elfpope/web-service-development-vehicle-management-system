<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:param name="dateFilter" />
	<xsl:param name="currentlyLoggedIn" />
	<xsl:template match="/">
		<ul class="breadcrumb" style="margin-top:75px;">
			<li>
				<a href="index.jsp">Home</a>
			</li>
			<li class="active">Trips</li>
		</ul>
		<div class="container">
			<h1>
				Trips starting on
				<xsl:value-of select="$dateFilter" />
			</h1>
			<table class="table table-striped table-hover ">
				<thead>
					<tr>
						<th>Trip ID</th>
						<th>Registration Number</th>
						<th>Driver ID</th>
						<th>Driver Name</th>
						<th>Start Date</th>
						<th>Start Time</th>
						<th>End Date</th>
						<th>End Time</th>
						<th>Description</th>
						<th>Kilometres</th>
						<xsl:if test="$currentlyLoggedIn = 'true'">
							<th>Delete</th>
						</xsl:if>
					</tr>
				</thead>
				<tbody>
					<xsl:apply-templates />
				</tbody>
			</table>
		</div>
	</xsl:template>


	<xsl:template match="vehicle/*[not(self::trip)]">
	</xsl:template>

	<xsl:template match="trip">
		<xsl:if test="startDate = $dateFilter and deleted = 'false'">
			<tr>
				<xsl:apply-templates />
			</tr>
		</xsl:if>
	</xsl:template>

	<xsl:template
		match="id|regoNumber|driverId|driverName|startDate|startTime|endDate|endTime|description|kilometres">
		<td>
			<xsl:apply-templates />
		</td>
	</xsl:template>

	<xsl:template match="deleted">
		<xsl:if test="$currentlyLoggedIn = 'true'">
			<td>
				<a href="#" data-toggle="modal" data-target="#deleteTripModal">
					<span class="glyphicon glyphicon-remove"></span>
				</a>
			</td>
		</xsl:if>
	</xsl:template>

	<xsl:template match="deletedById" />
</xsl:stylesheet>