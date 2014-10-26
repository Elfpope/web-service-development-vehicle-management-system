<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:param name="dateFilter" />
	<xsl:param name="currentlyLoggedIn" />
	<xsl:template match="/">
		<ul class="breadcrumb" style="margin-top:75px;">
			<li>
				<a href="index.jsp">Home</a>
			</li>
			<li class="active">Trips</li>
		</ul>	
		<xsl:choose>
			<xsl:when test="$dateFilter = ''">
				<div class="container">
					<h1>Trip information not found</h1>
				</div>
			</xsl:when>	
			<xsl:otherwise>
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
			</xsl:otherwise>
		</xsl:choose>	
	</xsl:template>


	<xsl:template match="vehicle/*[not(self::trip)]">
	</xsl:template>

	<xsl:template match="trip">
		<xsl:if test="startDate = $dateFilter and deleted = 'false'">
			<tr>
				<xsl:apply-templates />
				<xsl:if test="$currentlyLoggedIn = 'true'">
					<td>
						<a href="#" data-toggle="modal" data-target="#deleteTripModal">
							<span class="glyphicon glyphicon-remove"></span>
						</a>
					</td>
					<div class="modal fade" id="deleteTripModal{id}" tabindex="-1"
						role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">
										<span aria-hidden="true">x</span>
										<span class="sr-only">Close</span>
									</button>
									<h4 class="modal-title" id="myModalLabel">Delete Trip</h4>
								</div>
								<div class="modal-body">
									Are you sure you wish to delete this trip?
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Cancel</button>
									<a href="deleteTripAction.jsp?tripId={id}" type="button"
										class="btn btn-primary">Yes</a>
								</div>
							</div>
						</div>
					</div>
				</xsl:if>
			</tr>
		</xsl:if>
	</xsl:template>

	<xsl:template
		match="id|regoNumber|driverId|driverName|startDate|startTime|endDate|endTime|description|kilometres">
		<td>
			<xsl:apply-templates />
		</td>
	</xsl:template>
	
	<xsl:template match="startDate|endDate">
		<td>
			<xsl:variable name="date" select="current()" />
			<a href="tripsByDate.jsp?date={$date}">
				<xsl:value-of select="current()" />
			</a>
		</td>
	</xsl:template>

	<xsl:template match="regoNumber">
		<td>
			<xsl:variable name="regoNum" select="current()" />
			<a href="vehicle.jsp?regoNumber={$regoNum}">
				<xsl:value-of select="current()" />
			</a>
		</td>
	</xsl:template>
	
	<xsl:template match="deleted|deletedById" />
</xsl:stylesheet>