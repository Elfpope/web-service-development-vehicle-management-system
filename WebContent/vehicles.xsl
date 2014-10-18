<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<head>
			</head>
			<body>
				<table class="table table-striped table-hover ">
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
			</body>
		</html>
	</xsl:template>

	<xsl:template match="vehicle">
		<tr>
			hello
		</tr>
	</xsl:template>
</xsl:stylesheet>