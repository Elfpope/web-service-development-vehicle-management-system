<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:param name="filter" />
	<xsl:template match="/">
		<ul class="breadcrumb" style="margin-top:75px;">
			<li>
				<a href="index.jsp">Home</a>
			</li>
			<li class="active">Vehicle</li>
		</ul>
		<div class="container">
			<xsl:apply-templates />
		</div>
	</xsl:template>

	<xsl:template match="vehicle">
		<xsl:choose>
			<xsl:when test="regoNumber = $filter">
				<h1>
					Vehicle Information
					<xsl:value-of select="regoNumber" />
				</h1>
				<table class="table">
					<tr>
						<th>Registration Number</th>
						<td>
							<xsl:value-of select="regoNumber" />
						</td>
					</tr>
					<tr>
						<th>Type</th>
						<td>
							<xsl:value-of select="vehicleType" />
						</td>
					</tr>
					<tr>
						<th>Make</th>
						<td>
							<xsl:value-of select="make" />
						</td>
					</tr>
					<tr>
						<th>Model</th>
						<td>
							<xsl:value-of select="model" />
						</td>
					</tr>
					<tr>
						<th>Colour</th>
						<td>
							<xsl:value-of select="colour" />
						</td>
					</tr>
					<tr>
						<th>Kilometres travelled</th>
						<td>
							<xsl:value-of select="kilometres" />
						</td>
					</tr>
				</table>
				<h1>
					Trip Information
				</h1>
				<table class="table table-striped table-hover ">
					<thead>
						<tr>
							<th>Trip ID</th>
							<th>Driver ID</th>
							<th>Driver Name</th>
							<th>Start Date</th>
							<th>Start Time</th>
							<th>End Date</th>
							<th>End Time</th>
							<th>Description</th>
							<th>Kilometres</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<xsl:apply-templates />
					</tbody>
				</table>
			</xsl:when>
			<xsl:when test="$filter = ''">
				WELPS
			</xsl:when>
		</xsl:choose>

	</xsl:template>

	<xsl:template match="vehicle/*[not(self::trip)]">
	</xsl:template>

	<xsl:template match="trip">
		<xsl:if test="deleted = 'false'">
			<tr>
				<xsl:apply-templates />
				<td></td>
			</tr>
		</xsl:if>
	</xsl:template>

	<xsl:template match="startDate|endDate">
		<td>
			<xsl:apply-templates />
		</td>
	</xsl:template>
	
	<xsl:template
		match="id|driverId|driverName|startTime|endTime|description|kilometres">
		<td>
			<xsl:apply-templates />
		</td>
	</xsl:template>

	<xsl:template match="trip/regoNumber|deleted">
	</xsl:template>

</xsl:stylesheet>